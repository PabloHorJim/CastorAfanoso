    // Sync number box with slider value
    const slider = document.getElementById("radius");
    const numberBox = document.getElementById("radiusValue");

    slider.oninput = function() {
        numberBox.value = this.value;
    }

    numberBox.oninput = function() {
        // if (this.value < 5 && this.value != "")
        //     this.value = 5;
        // else if (this.value > 1000)
        //     this.value = 1000;
        slider.value = this.value;
    }