    // Sync number box with slider value
    const slider = document.getElementById("radius");
    const numberBox = document.getElementById("radiusValue");

    slider.oninput = function() {
        numberBox.value = this.value;
    }

    numberBox.oninput = function() {
        slider.value = this.value;
    }