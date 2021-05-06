const btnWrapper = document.querySelector('.btn_wrapper')
const selfVideo = document.querySelector('.self_video')
const myVideo = document.createElement("video");
const enteranceBtn = document.querySelector('.entrance_btn');
const firstGuid = document.querySelector('.first_guid')
const mouth = document.querySelector('.monster__mouth');
const arr = [0,0,0,0,0,0,0,0,0,0,0,0,2,3]
let text;
let answer = 0;
myVideo.muted = true;

enteranceBtn.addEventListener('click',()=>{
  sayHello()
  firstGuid.classList.add('hide_guid');
    const audio = new Audio(`/audio/sound1.mp3`);
    audio.loop = false; // 반복재생하지 않음
    audio.volume = 0.5; // 음량 설정
    audio.play(); // sound1.mp3 재생
    recognition.start();
    setTimeout(()=>{
      startFaceDetecting()
    },500)
})

function sayHello(){
  mouth.style.animation = "hello 1.75s forwards"
}

function saySpeek(){
  console.log('start')
  mouth.style.animation = "mouth1 1.75s forwards"
}

function sayLongSpeek(){
  mouth.style.animation = "mouth 3.75s forwards"
}
const varEmotion = {
  angry: 0,
  disgusted: 0,
  fearful: 0,
  happy: 0,
  neutral: 0,
  sad: 0,
  surprised: 0,
};
Promise.all([
  faceapi.nets.tinyFaceDetector.loadFromUri("/models"),
  faceapi.nets.faceLandmark68Net.loadFromUri("/models"),
  faceapi.nets.faceRecognitionNet.loadFromUri("/models"),
  faceapi.nets.faceExpressionNet.loadFromUri("/models"),
]);


btnWrapper.addEventListener('click',e => {
  if(e.target.classList.contains('btn')){
    const id = e.target.dataset.value;
    const audio = new Audio(`/audio/sound${id}.mp3`);
    audio.loop = false; // 반복재생하지 않음
    audio.volume = 0.5; // 음량 설정
    // audio.play(); // sound1.mp3 재생
  }
})



let myVideoStream;

var getUserMedia =
  navigator.getUserMedia ||
  navigator.webkitGetUserMedia ||
  navigator.mozGetUserMedia;

  function startFaceDetecting(){

  navigator.mediaDevices
  .getUserMedia({
    video: true,
    audio: false,
  })
  .then((stream) => {
    myVideoStream = stream;
    addVideoStream(myVideo, stream);
  })

function addVideoStream(video, stream) {
  video.srcObject = stream;
  video.id = 'video-live';
  video.addEventListener("loadedmetadata", () => {
    video.play();
  });
  selfVideo.append(video);
  video.enabled = true;
    video.addEventListener("play", () => {
      if (document.querySelector("canvas")) {
        document.querySelector("canvas").remove();
      }

      const canvas = faceapi.createCanvasFromMedia(video);
      selfVideo.append(canvas);
      const displaySize = {
        width: video.clientWidth,
        height: video.clientHeight,
      };
      // console.log(displaySize, video.clientWidth);
      faceapi.matchDimensions(canvas, displaySize);
      setInterval(async () => {
        const detections = await faceapi
          .detectAllFaces(video, new faceapi.TinyFaceDetectorOptions())
          .withFaceLandmarks()
          .withFaceExpressions();
        const resizedDetections = faceapi.resizeResults(
          detections,
          displaySize
        );
        if(resizedDetections && resizedDetections[0]){
          const arr = resizedDetections[0].expressions;
          const emotion = Object.keys(arr).sort(function (a, b) {
            return -arr[a] + arr[b];
          });
          varEmotion[emotion[0]] += 1;
        }
        // console.log(varEmotion);
        canvas.getContext("2d").clearRect(0, 0, canvas.width, canvas.height);
        faceapi.draw.drawDetections(canvas, resizedDetections);
        faceapi.draw.drawFaceLandmarks(canvas, resizedDetections);
        faceapi.draw.drawFaceExpressions(canvas, resizedDetections);
        // console.log(varEmotion);
      }, 100);
  })
}    
}


const textSection = document.querySelector('.text');

window.SpeechRecognition = window.SpeechRecognition || window.webkitSpeechRecognition;

const recognition = new window.SpeechRecognition();
recognition.interimResults = true;

let p =document.createElement('span');
recognition.addEventListener('result',(e)=>{
  console.log('입력되었다')
  text = Array.from(e.results)
  .map(result => result[0])
  .map(result => result.transcript)
  .join('');
  p.innerText = text;
  // textSection.appendChild(p)
  console.log(text)
  if(e.results[0].isFinal){
  let p =document.createElement('span');
  p.innerText = " "+text;
  textSection.appendChild(p)
  if(text.includes('안녕') && answer === 0){
    const audio = new Audio(`/audio/sound${1}.mp3`);
    audio.loop = false; // 반복재생하지 않음
    audio.volume = 0.5; // 음량 설정
    audio.play(); // sound1.mp3 재생
  }

  if(text.includes('다음에 또 올게') && answer === 0){
    const audio = new Audio(`/audio/sound${4}.mp3`);
    console.log(varEmotion['happy'])
    const varEmotion_current = varEmotion['happy']
    let now;
    audio.loop = false; // 반복재생하지 않음
    audio.volume = 0.5; // 음량 설정
    audio.play(); // sound1.mp3 재생
    sayLongSpeek();
    setTimeout(()=>{
      now =varEmotion['happy']
      console.log('now',now,varEmotion_current)
      if(now - varEmotion_current >= 2){
        console.log('고마워')
        mouth.style.animation = 'stop 1s'
        saySpeek();
        let audio = new Audio(`/audio/sound${5}.mp3`);
        console.log(varEmotion['happy'])
        audio.loop = false; // 반복재생하지 않음
        audio.volume = 0.5; // 음량 설정
        audio.play(); // sound1.mp3 재생
        setTimeout(() => {
          audio = new Audio(`/audio/sound${6}.mp3`);
          console.log(varEmotion['happy'])
          audio.loop = false; // 반복재생하지 않음
          audio.volume = 0.5; // 음량 설정
          audio.play(); // sound1.mp3 재생
        },2200);
      }
    },9000);
  }
}

})

recognition.addEventListener('end',()=>{
  console.log('end')
  // console.log(arr[Math.floor(Math.random()*arr.length)])
  const randomNumber = arr[Math.floor(Math.random()*arr.length)]
  // console.log(Math.random() * 10)
  // if(randomNumber != 0){
  //   console.log('실행할거야')
  //   const audio = new Audio(`/audio/sound${randomNumber}.mp3`);
  //   audio.loop = false; // 반복재생하지 않음
  //   audio.volume = 0.5; // 음량 설정
  //   audio.play(); // sound1.mp3 재생
  // }
  recognition.start();
})
