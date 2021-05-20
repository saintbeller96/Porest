let colorCode = '#ffffff';
let colorChanged = false;
let resotre_array = [];
let currentDraw = '';
export const colorValue = value => {
  colorCode = value;
  colorChanged = true;
};

export const init = () => {
  const wrapper = document.querySelector('.drawing-wrapper');
  const changeDrawing = document.querySelector('.change__drawing');

  changeDrawing.addEventListener('change', e => {
    let value = e.target.value;
    if (currentDraw == '') {
      currentDraw = value;
      wrapper.classList.add(value);
    } else {
      wrapper.classList.remove(currentDraw);
      wrapper.classList.add(value);
      currentDraw = value;
    }
  });

  const canvas = document.querySelector('#drawing-canvas');
  const cntx = canvas.getContext('2d');
  const painting = document.querySelector('#content');
  const paintStyle = getComputedStyle(painting);
  let index = -1;

  canvas.width = parseInt(paintStyle.getPropertyValue('width'));
  canvas.height = parseInt(paintStyle.getPropertyValue('height'));

  let mouse = { x: 0, y: 0 };

  canvas.addEventListener('mousemove', function(e) {
    mouse.x = e.clientX - this.offsetLeft;
    mouse.y = e.clientY - this.offsetTop;
  });

  cntx.lineWidth = 5;
  cntx.lineJoin = 'round';
  cntx.lineCap = 'round';

  const thickness = document.querySelector('#thickness');
  const color = document.querySelector('#color');
  // const colorCode = document.querySelector('.color-code');
  const dropdownBtn = document.querySelector('.e-dropdown-btn');
  dropdownBtn.addEventListener('click', function() {
    const applyBtn = document.querySelector('.e-apply');
    applyBtn.addEventListener('click', function() {
      changecolor();
    });
  });
  thickness.addEventListener('change', changethickness);

  color.addEventListener('change', function(event) {
    changecolor(event);
  });

  function changethickness() {
    let thicknessVal = document.querySelector('#thickness').value;
    cntx.lineWidth = thicknessVal;
  }
  const changecolor = () => {
    cntx.strokeStyle = colorCode;
  };
  if (colorChanged) {
    changecolor();
  }
  canvas.addEventListener(
    'mousedown',
    function() {
      cntx.beginPath();
      cntx.moveTo(mouse.x, mouse.y);
      canvas.addEventListener('mousemove', onPaint, false);
    },
    false,
  );

  canvas.addEventListener(
    'mouseup',
    function() {
      resotre_array.push(cntx.getImageData(0, 0, canvas.width, canvas.height));
      index += 1;
      canvas.removeEventListener('mousemove', onPaint, false);
    },
    false,
  );

  const clearBtn = document.querySelector('.clear');
  const undoBtn = document.querySelector('.undo');
  clearBtn.addEventListener('click', clearcanvas);
  undoBtn.addEventListener('click', undo);
  function clearcanvas() {
    cntx.clearRect(0, 0, canvas.width, canvas.height);
    resotre_array = [];
    index = -1;
  }

  function undo() {
    if (index <= 0) {
      clearcanvas();
    } else {
      index -= 1;
      resotre_array.pop();
      cntx.putImageData(resotre_array[index], 0, 0);
    }
  }

  const onPaint = function() {
    cntx.lineTo(mouse.x, mouse.y);
    cntx.stroke();
  };
};
