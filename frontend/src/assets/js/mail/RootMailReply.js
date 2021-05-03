export const init = () => {
    
  const envelope = document.querySelector('.envelope');
  const mailFormInput = document.querySelectorAll('.mailform input');
  const mailFormTextArea = document.querySelector('.mailform textarea');
  const sendBtn = document.querySelector('.sendBtn')
  
  
  if(!envelope.classList.contains('open')){
    envelope.addEventListener('click',function(){
      envelope.classList.remove('new');
      envelope.classList.add('open');
    })
  }
  
  mailFormInput.forEach(ele => {
    ele.addEventListener('keyup',function(){
    const prevEle = ele.previousElementSibling;
    if(ele.value !== ""){
      prevEle.classList.add('show')
    }else {
      prevEle.classList.remove('show')
    }
  })
  })
    
  
  mailFormInput.forEach(ele => {
    ele.addEventListener('focus',function(){
    const prevEle = ele.previousElementSibling;
      if(prevEle){
        
    prevEle.classList.add('focus');
      }
  })
  })
  
  mailFormInput.forEach(ele => {
    ele.addEventListener('blur',function(){
    const prevEle = ele.previousElementSibling;
      if(prevEle){
        
    prevEle.classList.remove('focus');
      }
  })
  })
    
    
  
  mailFormTextArea.addEventListener('keyup',function(){
    const prevEle = mailFormTextArea.previousElementSibling;
    if(mailFormTextArea.value !== ""){
      prevEle.classList.add('show')
    }else {
      prevEle.classList.remove('show')
    }
  })
  
  
    mailFormTextArea.addEventListener('focus',function(){
    const prevEle = mailFormTextArea.previousElementSibling;
    prevEle.classList.add('focus');
  })
  
  mailFormTextArea.addEventListener('blur',function(){
    const prevEle = mailFormTextArea.previousElementSibling;
    prevEle.classList.remove('focus');
  })
    
  
  sendBtn.addEventListener('click',(event)=>{
    event.preventDefault();
    envelope.classList.remove('open');
    envelope.classList.add('send');
  })

}