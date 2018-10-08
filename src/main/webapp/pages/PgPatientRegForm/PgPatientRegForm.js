Application.$controller("PgPatientRegFormPageController", ["$scope", function($scope) {
    "use strict";

    var signaturePad;
    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {

        ///////////// Signature Pad Start///////////////

        var canvas = document.querySelector("canvas");
        signaturePad = new SignaturePad(canvas, {
            minWidth: 1,
            maxWidth: 1,
            penColor: "rgb(66, 133, 244)",
            onEnd: function() {
                // $scope.Widgets.dischargeNurseSigText.datavalue = JSON.stringify(signaturePad.toData());
                $scope.Variables.stvBase64ImageUrl.dataSet.dataValue = signaturePad.toDataURL();
            }
        });

        function resizeCanvas() {
            var ratio = Math.max(window.devicePixelRatio || 1, 1);
            canvas.width = canvas.offsetWidth * ratio;
            canvas.height = canvas.offsetHeight * ratio;
            // canvas.width = 310 * ratio;
            // canvas.height = 415 * ratio;
            canvas.getContext("2d").scale(ratio, ratio);
            signaturePad.clear(); // otherwise isEmpty() might return incorrect value
        }

        window.addEventListener("resize", resizeCanvas);
        resizeCanvas();

        var wrapper = document.getElementById("signature-pad");
        var clearButton = wrapper.querySelector("[data-action=clear]");
        // var changeColorButton = wrapper.querySelector("[data-action=change-color]");
        var undoButton = wrapper.querySelector("[data-action=undo]");
        clearButton.addEventListener("click", function(event) {
            signaturePad.clear();
            // $scope.Widgets.dischargeNurseSigText.datavalue = '';
        });
        undoButton.addEventListener("click", function(event) {
            var data = signaturePad.toData();

            if (data) {
                data.pop(); // remove the last dot or line
                signaturePad.fromData(data);
                // $scope.Widgets.dischargeNurseSigText.datavalue = data;
            }
        });

        // function download(dataURL, filename) {
        //     if (navigator.userAgent.indexOf("Safari") > -1 && navigator.userAgent.indexOf("Chrome") === -1) {
        //         window.open(dataURL);
        //     } else {
        //         var blob = dataURLToBlob(dataURL);
        //         var url = window.URL.createObjectURL(blob);

        //         var a = document.createElement("a");
        //         a.style = "display: none";
        //         a.href = url;
        //         a.download = filename;

        //         document.body.appendChild(a);
        //         a.click();

        //         window.URL.revokeObjectURL(url);
        //     }
        // }

        ///////////// Signature Pad End///////////////

        //Set Year List from this year to 1900
        var thisYear = new Date().getFullYear();
        var yearList = [];
        for (var i = thisYear; i >= 1900; i--) {
            yearList.push(i);
        }
        $scope.Variables.stvYearList.dataSet = yearList;


        //Set Year List from this year+10 to 1900 For ExpiryDates
        var yearListPlusTen = [];
        for (var i = (thisYear + 10); i >= thisYear; i--) {
            yearListPlusTen.push(i);
        }
        $scope.Variables.stvYearListPlusTenYears.dataSet = yearListPlusTen;

        var options = {
            types: ['address'],
            componentRestrictions: {
                country: 'au'
            }
        };
        debugger;

        var autocomplete, autocomplete2, autocomplete3, autocomplete4, autocomplete5, autocomplete6, autocomplete7;
        if (typeof google === "undefined") {
            debugger;
            $.getScript('https://maps.googleapis.com/maps/api/js?key=AIzaSyAnsXUumRPOBcoNyNA-RiPIMSQnni_M_xw&libraries=places').done(function() {
                autocomplete = new google.maps.places.Autocomplete($('[name=address1_formWidget')[0], options);

                autocomplete.addListener('place_changed', function() {

                    // Clear the address fields before the circus begins
                    $scope.Widgets.address1.datavalue = '';
                    $scope.Widgets.address2.datavalue = '';
                    $scope.Widgets.suburb.datavalue = '';
                    $scope.Widgets.state.datavalue = '';
                    $scope.Widgets.postcode.datavalue = '';
                    $scope.Widgets.country.datavalue = '';
                    $scope.Widgets.streetname.datavalue = '';


                    var place = autocomplete.getPlace();
                    if (!place.geometry) {
                        alert("Autocomplete's returned place contains no geometry");
                        return;
                    }

                    var address = '';
                    if (place.address_components) {

                        //use this value later to split the address 
                        var cSuburb = '';

                        for (var i = 0; i < place.address_components.length; i++) {
                            var addr = place.address_components[i];
                            var getCountry;
                            if (addr.types[0] == 'administrative_area_level_1') {
                                $scope.Widgets.state.datavalue = addr.short_name;
                            } else if (addr.types[0] == 'street_number') {
                                $scope.Widgets.address2.datavalue = addr.short_name;
                            } else if (addr.types[0] == 'country') {
                                $scope.Widgets.country.datavalue = addr.long_name;
                            } else if (addr.types[0] == 'route') {
                                $scope.Widgets.streetname.datavalue = addr.short_name;
                            } else {
                                if (addr.types[0] == 'locality') {

                                    cSuburb = addr.long_name;
                                    $scope.Widgets.suburb.datavalue = cSuburb.toUpperCase();

                                } else if (addr.types[0] == 'postal_code') {
                                    $scope.Widgets.postcode.datavalue = addr.short_name;
                                }
                            }
                        }

                        //postal_code               //$scope.Widgets.suburb.datavalue = (place.address_components[0] && place.address_components[0].short_name || '');
                        var cFulAddress = place.formatted_address;
                        //$scope.Widgets.address1.datavalue = cFulAddress.substring(0, cFulAddress.lastIndexOf(cSuburb));
                        $scope.Widgets.address1.datavalue = cFulAddress;

                        // $scope.Widgets.pgPatientPortal.redraw(true);


                        //  address = [
                        //   (place.address_components[0] && place.address_components[0].short_name || ''), (place.address_components[1] && place.address_components[1].short_name || ''), (place .address_components[2] && place.address_components[2].short_name || '')
                        //    ].join(' ');
                    }


                    // infowindow.setContent('<div><strong>' + place.name + '</strong><br>' + address);
                    //infowindow.open(map, marker);
                });

                autocomplete2 = new google.maps.places.Autocomplete($('[name=txtAddress2_formWidget')[0], options);
                autocomplete2.addListener('place_changed', function() {

                    // Clear the address fields before the circus begins
                    $scope.Widgets.txtAddress2.datavalue = '';
                    $scope.Widgets.address3.datavalue = '';
                    $scope.Widgets.streetname2.datavalue = '';
                    $scope.Widgets.suburb2.datavalue = '';
                    $scope.Widgets.state2.datavalue = '';
                    $scope.Widgets.postcode2.datavalue = '';
                    $scope.Widgets.country2.datavalue = '';



                    var place = autocomplete2.getPlace();
                    if (!place.geometry) {
                        alert("Autocomplete's returned place contains no geometry");
                        return;
                    }

                    var address = '';
                    if (place.address_components) {

                        //use this value later to split the address 
                        var cSuburb = '';

                        for (var i = 0; i < place.address_components.length; i++) {
                            var addr = place.address_components[i];
                            var getCountry;
                            if (addr.types[0] == 'administrative_area_level_1') {
                                $scope.Widgets.state2.datavalue = addr.short_name;
                            } else if (addr.types[0] == 'street_number') {
                                $scope.Widgets.address3.datavalue = addr.short_name;
                            } else if (addr.types[0] == 'country') {
                                $scope.Widgets.country2.datavalue = addr.long_name;
                            } else if (addr.types[0] == 'route') {
                                $scope.Widgets.streetname2.datavalue = addr.short_name;
                            } else {
                                if (addr.types[0] == 'locality') {

                                    cSuburb = addr.long_name;
                                    $scope.Widgets.suburb2.datavalue = cSuburb.toUpperCase();

                                } else if (addr.types[0] == 'postal_code') {
                                    $scope.Widgets.postcode2.datavalue = addr.short_name;
                                }
                            }
                        }
                        var cFulAddress = place.formatted_address;
                        $scope.Widgets.txtAddress2.datavalue = cFulAddress;
                    }
                });

                //Address3
                autocomplete3 = new google.maps.places.Autocomplete($('[name=txtAddress3_formWidget')[0], options);
                autocomplete3.addListener('place_changed', function() {

                    // Clear the address fields before the circus begins
                    $scope.Widgets.txtAddress3.datavalue = '';
                    $scope.Widgets.address4.datavalue = '';
                    $scope.Widgets.streetname3.datavalue = '';
                    $scope.Widgets.suburb3.datavalue = '';
                    $scope.Widgets.state3.datavalue = '';
                    $scope.Widgets.postcode3.datavalue = '';
                    $scope.Widgets.country3.datavalue = '';



                    var place = autocomplete3.getPlace();
                    if (!place.geometry) {
                        alert("Autocomplete's returned place contains no geometry");
                        return;
                    }

                    var address = '';
                    if (place.address_components) {

                        //use this value later to split the address 
                        var cSuburb = '';

                        for (var i = 0; i < place.address_components.length; i++) {
                            var addr = place.address_components[i];
                            var getCountry;
                            if (addr.types[0] == 'administrative_area_level_1') {
                                $scope.Widgets.state3.datavalue = addr.short_name;
                            } else if (addr.types[0] == 'street_number') {
                                $scope.Widgets.address4.datavalue = addr.short_name;
                            } else if (addr.types[0] == 'country') {
                                $scope.Widgets.country3.datavalue = addr.long_name;
                            } else if (addr.types[0] == 'route') {
                                $scope.Widgets.streetname3.datavalue = addr.short_name;
                            } else {
                                if (addr.types[0] == 'locality') {

                                    cSuburb = addr.long_name;
                                    $scope.Widgets.suburb3.datavalue = cSuburb.toUpperCase();

                                } else if (addr.types[0] == 'postal_code') {
                                    $scope.Widgets.postcode3.datavalue = addr.short_name;
                                }
                            }
                        }
                        var cFulAddress = place.formatted_address;
                        $scope.Widgets.txtAddress3.datavalue = cFulAddress;
                    }
                });

                //Address4
                autocomplete4 = new google.maps.places.Autocomplete($('[name=txtAddress4_formWidget')[0], options);
                autocomplete4.addListener('place_changed', function() {

                    // Clear the address fields before the circus begins
                    $scope.Widgets.txtAddress4.datavalue = '';
                    $scope.Widgets.address5.datavalue = '';
                    $scope.Widgets.streetname4.datavalue = '';
                    $scope.Widgets.suburb4.datavalue = '';
                    $scope.Widgets.state4.datavalue = '';
                    $scope.Widgets.postcode4.datavalue = '';
                    $scope.Widgets.country4.datavalue = '';



                    var place = autocomplete4.getPlace();
                    if (!place.geometry) {
                        alert("Autocomplete's returned place contains no geometry");
                        return;
                    }

                    var address = '';
                    if (place.address_components) {

                        //use this value later to split the address 
                        var cSuburb = '';

                        for (var i = 0; i < place.address_components.length; i++) {
                            var addr = place.address_components[i];
                            var getCountry;
                            if (addr.types[0] == 'administrative_area_level_1') {
                                $scope.Widgets.state4.datavalue = addr.short_name;
                            } else if (addr.types[0] == 'street_number') {
                                $scope.Widgets.address5.datavalue = addr.short_name;
                            } else if (addr.types[0] == 'country') {
                                $scope.Widgets.country4.datavalue = addr.long_name;
                            } else if (addr.types[0] == 'route') {
                                $scope.Widgets.streetname4.datavalue = addr.short_name;
                            } else {
                                if (addr.types[0] == 'locality') {

                                    cSuburb = addr.long_name;
                                    $scope.Widgets.suburb4.datavalue = cSuburb.toUpperCase();

                                } else if (addr.types[0] == 'postal_code') {
                                    $scope.Widgets.postcode4.datavalue = addr.short_name;
                                }
                            }
                        }
                        var cFulAddress = place.formatted_address;
                        $scope.Widgets.txtAddress4.datavalue = cFulAddress;
                    }
                });

                //Address5
                autocomplete5 = new google.maps.places.Autocomplete($('[name=txtAddress5_formWidget')[0], options);
                autocomplete5.addListener('place_changed', function() {

                    // Clear the address fields before the circus begins
                    $scope.Widgets.txtAddress5.datavalue = '';
                    $scope.Widgets.address6.datavalue = '';
                    $scope.Widgets.streetname5.datavalue = '';
                    $scope.Widgets.suburb5.datavalue = '';
                    $scope.Widgets.state5.datavalue = '';
                    $scope.Widgets.postcode5.datavalue = '';
                    $scope.Widgets.country5.datavalue = '';



                    var place = autocomplete5.getPlace();
                    if (!place.geometry) {
                        alert("Autocomplete's returned place contains no geometry");
                        return;
                    }

                    var address = '';
                    if (place.address_components) {

                        //use this value later to split the address 
                        var cSuburb = '';

                        for (var i = 0; i < place.address_components.length; i++) {
                            var addr = place.address_components[i];
                            var getCountry;
                            if (addr.types[0] == 'administrative_area_level_1') {
                                $scope.Widgets.state5.datavalue = addr.short_name;
                            } else if (addr.types[0] == 'street_number') {
                                $scope.Widgets.address6.datavalue = addr.short_name;
                            } else if (addr.types[0] == 'country') {
                                $scope.Widgets.country5.datavalue = addr.long_name;
                            } else if (addr.types[0] == 'route') {
                                $scope.Widgets.streetname5.datavalue = addr.short_name;
                            } else {
                                if (addr.types[0] == 'locality') {

                                    cSuburb = addr.long_name;
                                    $scope.Widgets.suburb5.datavalue = cSuburb.toUpperCase();

                                } else if (addr.types[0] == 'postal_code') {
                                    $scope.Widgets.postcode5.datavalue = addr.short_name;
                                }
                            }
                        }
                        var cFulAddress = place.formatted_address;
                        $scope.Widgets.txtAddress5.datavalue = cFulAddress;
                    }
                });

                //Address6
                autocomplete6 = new google.maps.places.Autocomplete($('[name=txtAddress6_formWidget')[0], options);
                autocomplete6.addListener('place_changed', function() {

                    // Clear the address fields before the circus begins
                    $scope.Widgets.txtAddress6.datavalue = '';
                    $scope.Widgets.address7.datavalue = '';
                    $scope.Widgets.streetname6.datavalue = '';
                    $scope.Widgets.suburb6.datavalue = '';
                    $scope.Widgets.state6.datavalue = '';
                    $scope.Widgets.postcode6.datavalue = '';
                    $scope.Widgets.country6.datavalue = '';



                    var place = autocomplete6.getPlace();
                    if (!place.geometry) {
                        alert("Autocomplete's returned place contains no geometry");
                        return;
                    }

                    var address = '';
                    if (place.address_components) {

                        //use this value later to split the address 
                        var cSuburb = '';

                        for (var i = 0; i < place.address_components.length; i++) {
                            var addr = place.address_components[i];
                            var getCountry;
                            if (addr.types[0] == 'administrative_area_level_1') {
                                $scope.Widgets.state6.datavalue = addr.short_name;
                            } else if (addr.types[0] == 'street_number') {
                                $scope.Widgets.address7.datavalue = addr.short_name;
                            } else if (addr.types[0] == 'country') {
                                $scope.Widgets.country6.datavalue = addr.long_name;
                            } else if (addr.types[0] == 'route') {
                                $scope.Widgets.streetname6.datavalue = addr.short_name;
                            } else {
                                if (addr.types[0] == 'locality') {

                                    cSuburb = addr.long_name;
                                    $scope.Widgets.suburb6.datavalue = cSuburb.toUpperCase();

                                } else if (addr.types[0] == 'postal_code') {
                                    $scope.Widgets.postcode6.datavalue = addr.short_name;
                                }
                            }
                        }
                        var cFulAddress = place.formatted_address;
                        $scope.Widgets.txtAddress6.datavalue = cFulAddress;
                    }
                });

                //Address7
                autocomplete7 = new google.maps.places.Autocomplete($('[name=txtAddress7_formWidget')[0], options);
                autocomplete7.addListener('place_changed', function() {

                    // Clear the address fields before the circus begins
                    $scope.Widgets.txtAddress7.datavalue = '';
                    $scope.Widgets.address8.datavalue = '';
                    $scope.Widgets.streetname7.datavalue = '';
                    $scope.Widgets.suburb7.datavalue = '';
                    $scope.Widgets.state7.datavalue = '';
                    $scope.Widgets.postcode7.datavalue = '';
                    $scope.Widgets.country7.datavalue = '';



                    var place = autocomplete7.getPlace();
                    if (!place.geometry) {
                        alert("Autocomplete's returned place contains no geometry");
                        return;
                    }

                    var address = '';
                    if (place.address_components) {

                        //use this value later to split the address 
                        var cSuburb = '';

                        for (var i = 0; i < place.address_components.length; i++) {
                            var addr = place.address_components[i];
                            var getCountry;
                            if (addr.types[0] == 'administrative_area_level_1') {
                                $scope.Widgets.state7.datavalue = addr.short_name;
                            } else if (addr.types[0] == 'street_number') {
                                $scope.Widgets.address8.datavalue = addr.short_name;
                            } else if (addr.types[0] == 'country') {
                                $scope.Widgets.country7.datavalue = addr.long_name;
                            } else if (addr.types[0] == 'route') {
                                $scope.Widgets.streetname7.datavalue = addr.short_name;
                            } else {
                                if (addr.types[0] == 'locality') {

                                    cSuburb = addr.long_name;
                                    $scope.Widgets.suburb7.datavalue = cSuburb.toUpperCase();

                                } else if (addr.types[0] == 'postal_code') {
                                    $scope.Widgets.postcode7.datavalue = addr.short_name;
                                }
                            }
                        }
                        var cFulAddress = place.formatted_address;
                        $scope.Widgets.txtAddress7.datavalue = cFulAddress;
                    }
                });
            });

        } else {
            autocomplete = new google.maps.places.Autocomplete($('[name=address1_formWidget]')[0]);
            autocomplete2 = new google.maps.places.Autocomplete($('[name=txtAddress2_formWidget]')[0]);
            autocomplete3 = new google.maps.places.Autocomplete($('[name=txtAddress3_formWidget]')[0]);
            autocomplete4 = new google.maps.places.Autocomplete($('[name=txtAddress4_formWidget]')[0]);
            autocomplete5 = new google.maps.places.Autocomplete($('[name=txtAddress5_formWidget]')[0]);
            autocomplete6 = new google.maps.places.Autocomplete($('[name=txtAddress6_formWidget]')[0]);
            autocomplete7 = new google.maps.places.Autocomplete($('[name=txtAddress7_formWidget]')[0]);
        }

    };




    $scope.btnSubmitTap = function($event, $isolateScope) {
        // $scope.Variables.stvBase64ImageUrl.dataSet.dataValue = signaturePad.toDataURL();
        // $scope.Variables.svSaveSignatureAsImage.invoke();
        debugger;
    };


    $scope.svSaveSignatureAsImageonSuccess = function(variable, data, options) {
        alert("image saved");
    };


    $scope.svSaveSignatureAsImageonError = function(variable, data, options) {
        alert("image saving failed");
    };

}]);