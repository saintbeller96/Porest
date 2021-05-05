<template>
  <body>
    <div class="wrapper">
      <div id="termometer">
        <div id="temperature" style="height:0" data-value="0°C"></div>
        <div id="graduations"></div>
      </div>
      <button @click="setTemperature">check</button>

      <div id="playground">
        <div id="range">
          <input id="minTemp" type="text" value="0" />
          <input type="range" min="0" max="100" value="80" />
          <input id="maxTemp" type="text" value="100" />
        </div>
        <p id="unit">Celcius C°</p>
      </div>
    </div>
  </body>
</template>

<script>
import { init } from '@/assets/js/Temperature.js';
import '../../assets/css/Temperature.css';
export default {
  data() {
    return {
      temperature: 50,
    };
  },
  mounted() {
    init();
  },
  methods: {
    changeTemperature() {},
    setTemperature() {
      const units = {
        Celcius: '°C',
        Fahrenheit: '°F',
      };

      const config = {
        minTemp: 0,
        maxTemp: 100,
        unit: 'Celcius',
      };
      const range = this.temperature;
      const temperature = document.getElementById('temperature');
      temperature.style.height = ((range.value - config.minTemp) / (config.maxTemp - config.minTemp)) * 100 + '%';
      temperature.dataset.value = range.value + units[config.unit];
    },
  },
};
</script>

<style scoped></style>
