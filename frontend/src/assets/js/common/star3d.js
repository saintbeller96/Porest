let scene, camera, renderer, starGeo, stars, geometry, star;

function init() {
  // 1. Create Scene
  scene = new THREE.Scene();
  // 2. Set Camera (FOV, Aspect, Near, Far)
  camera = new THREE.PerspectiveCamera(60, window.innerWidth / window.innerHeight, 1, 1000);
  camera.position.y = 50;
  camera.rotation.x = Math.PI / 2;

  // 3. Set Renderer: WebGLRenderer and Append to Page
  renderer = new THREE.WebGLRenderer({ antialias: true, alpha: true });
  renderer.setSize(window.innerWidth, window.innerHeight);
  const mainwrapper = document.querySelector('.star-3d');
  mainwrapper.appendChild(renderer.domElement);

  // Create Geometry, Texture, Material
  geometry = new THREE.Geometry();
  for (let i = 0; i < 2000; i++) {
    star = new THREE.Vector3(Math.random() * 600 - 300, Math.random() * 600 - 300, Math.random() * 600 - 300);
    star.velocity = 0;
    star.acceleration = 0.0006;
    geometry.vertices.push(star);
  }
  let sprite = new THREE.TextureLoader().load('https://s3-us-west-2.amazonaws.com/s.cdpn.io/1823170/star-sprite.png');
  let material = new THREE.PointsMaterial({
    color: 0xffffff,
    size: 0.7,
    map: sprite,
  });

  const stars = new THREE.Points(geometry, material);
  scene.add(stars);

  animate();
}

// 4. Create Render Loop/Animation and Function
function animate() {
  geometry.vertices.forEach(p => {
    p.velocity += p.acceleration;
    p.z -= p.velocity;
    if (p.z < -200) {
      p.z = 200;
      p.velocity = 0;
    }
  });
  geometry.verticesNeedUpdate = true;

  renderer.render(scene, camera);
  requestAnimationFrame(animate);
}

function onWindowResize() {
  camera.aspect = window.innerWidth / window.innerHeight;
  camera.updateProjectionMatrix();
  renderer.setSize(window.innerWidth, window.innerHeight);
}

export const star3D = () => {
  init();
  window.addEventListener('resize', onWindowResize, false);
};
