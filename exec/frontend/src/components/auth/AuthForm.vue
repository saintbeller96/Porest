<template>
  <div>
    <div class="paper-plane">
      <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 95.04 61.39">
        <g id="레이어_2" data-name="레이어 2">
          <g id="Capa_1" data-name="Capa 1">
            <g>
              <polygon class="cls-1" points="0 0 95.04 23.47 59.64 37.59 0 0" />
              <polygon class="cls-2" points="59.64 37.59 57.04 56.59 0 0 59.64 37.59" />
              <polygon class="cls-3" points="51 41.92 57.04 56.59 0 0 51 41.92" />
              <polygon class="cls-1" points="0 0 51 41.92 17.36 61.39 0 0" />
            </g>
          </g>
        </g>
      </svg>
    </div>
    <div class="paper-plane">
      <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 95.04 61.39">
        <g id="레이어_2" data-name="레이어 2">
          <g id="Capa_1" data-name="Capa 1">
            <g>
              <polygon class="cls-1" points="0 0 95.04 23.47 59.64 37.59 0 0" />
              <polygon class="cls-2" points="59.64 37.59 57.04 56.59 0 0 59.64 37.59" />
              <polygon class="cls-3" points="51 41.92 57.04 56.59 0 0 51 41.92" />
              <polygon class="cls-1" points="0 0 51 41.92 17.36 61.39 0 0" />
            </g>
          </g>
        </g>
      </svg>
    </div>
    <div class="paper-plane">
      <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 95.04 61.39">
        <g id="레이어_2" data-name="레이어 2">
          <g id="Capa_1" data-name="Capa 1">
            <g>
              <polygon class="cls-1" points="0 0 95.04 23.47 59.64 37.59 0 0" />
              <polygon class="cls-2" points="59.64 37.59 57.04 56.59 0 0 59.64 37.59" />
              <polygon class="cls-3" points="51 41.92 57.04 56.59 0 0 51 41.92" />
              <polygon class="cls-1" points="0 0 51 41.92 17.36 61.39 0 0" />
            </g>
          </g>
        </g>
      </svg>
    </div>
    <div class="paper-plane">
      <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 95.04 61.39">
        <g id="레이어_2" data-name="레이어 2">
          <g id="Capa_1" data-name="Capa 1">
            <g>
              <polygon class="cls-1" points="0 0 95.04 23.47 59.64 37.59 0 0" />
              <polygon class="cls-2" points="59.64 37.59 57.04 56.59 0 0 59.64 37.59" />
              <polygon class="cls-3" points="51 41.92 57.04 56.59 0 0 51 41.92" />
              <polygon class="cls-1" points="0 0 51 41.92 17.36 61.39 0 0" />
            </g>
          </g>
        </g>
      </svg>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.paper-plane {
  position: absolute;

  width: 50px;
  height: 50px;
  animation: paper1 8s ease-in-out infinite;
}

.paper-plane:nth-child(1) {
  top: 60%;
  right: 3%;
}

@keyframes paper1 {
  100% {
    transform: translate(-1000px, -1000px);
  }
}
.paper-plane:nth-child(2) {
  top: 40%;
  right: -13%;
}
.paper-plane:nth-child(3) {
  top: 100%;
  right: 50%;
}
.paper-plane:nth-child(4) {
  top: 80%;
  right: 30%;
}
.cls-1 {
  fill: rgba(255, 255, 255, 0.98);
}

.cls-1,
.cls-2,
.cls-3 {
  fill-rule: evenodd;
}

.cls-2 {
  fill: rgba(255, 255, 255, 0.3);
}

.cls-3 {
  fill: rgba(255, 255, 255, 0.2);
}
</style>
