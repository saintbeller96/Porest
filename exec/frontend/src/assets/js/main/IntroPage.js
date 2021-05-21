let camera, scene, renderer, particles, particle, material, particleCount, points, texture;
let xSpeed, ySpeed;
xSpeed = 0.0;
ySpeed = 0.00001;
let winWidth, winHeight;
winWidth = window.innerWidth;
winHeight = window.innerHeight;

export const startAnimation = () => {
  init();
  animate();
  window.addEventListener('resize', onWindowResize, false);
};

function init() {
  scene = new THREE.Scene();
  scene.fog = new THREE.FogExp2('#222', 0.001);

  camera = new THREE.PerspectiveCamera(75, winWidth / winHeight, 1, 1000);
  camera.position.z = 0;
  camera.position.y = 1;
  camera.rotation.x = Math.PI / 2;

  let sprite = new THREE.TextureLoader().load('https://s3-us-west-2.amazonaws.com/s.cdpn.io/1823170/star-sprite.png');

  material = new THREE.PointsMaterial({
    color: 0xffffff,
    size: 0.9,
    map: sprite,

    transparent: true,
    blending: THREE.AdditiveBlending,
  });

  particleCount = 35000;
  particles = new THREE.Geometry();

  for (var i = 0; i < particleCount; i++) {
    var px = Math.random() * 2000 - 1000;
    var py = Math.random() * 1000 - 1000;
    var pz = Math.random() * 2000 - 1000;
    particle = new THREE.Vector3(px, py, pz);
    particle.velocity = new THREE.Vector3(0, Math.random(), 0);
    particles.vertices.push(particle);
  }

  points = new THREE.Points(particles, material);
  points.sortParticles = true;
  scene.add(points);

  renderer = new THREE.WebGLRenderer({ antialias: true, alpha: true });
  renderer.setSize(winWidth, winHeight);
  //   renderer.setClearColor('#000', 1);
  document.getElementById('canvas').appendChild(renderer.domElement);
}

function animate() {
  requestAnimationFrame(animate);

  scene.rotation.y += xSpeed;

  var i = particleCount;
  while (i--) {
    var particle = particles.vertices[i];
    if (particle.y > 1000) {
      particle.y = -1000;
      particle.velocity.y = Math.random();
    }
    particle.velocity.y += Math.random() * ySpeed;
    particle.add(particle.velocity);
  }
  points.geometry.verticesNeedUpdate = true;

  render();
}

function render() {
  camera.lookAt(scene.position);
  renderer.render(scene, camera);
}

function onWindowResize() {
  camera.aspect = window.innerWidth / window.innerHeight;
  camera.updateProjectionMatrix();
  renderer.setSize(window.innerWidth, window.innerHeight);
}
