<template>
  <div>
    <div :class="open ? 'form open' : 'form'" @click="toggleOpen">
      <div class="info">회원가입 약관 안내</div>
      <div class="detail">
        <p>제 1조 (목적)</p>
        본 약관은 Porest(이하 "Porest")가 제공하는 사이트 이용과 관련하여
        기본적인 사항을 규정함을 목적으로 합니다.
        <p>제 2조 (약관의 효력 및 변경)</p>
        (1) 이 약관은 Porest 사이트 화면에 게시하거나 기타의 방법으로 회원에게
        공시함으로써 효력이 발생합니다. (2) Porest 관리자(이하 "관리자")는
        약관의 규제 등에 관한 법률, 전자거래기본법, 정보통신사업법 기타
        관련법령을 위배하지 않는 범위에서 이 약관을 변경할 수 있으며, 변경된
        약관은 적용일자 및 개정 사유를 명시하여 적용일자 전일까지 제1항과 같은
        방법으로 공지합니다. (3) 회원은 변경된 약관에 동의하지 않을 경우 서비스
        이용을 중단하고 Porest을 탈퇴할 수 있습니다. 변경된 약관의 적용일자
        이후의 계속적인 서비스 이용은 약관의 변경 사항에 동의한 것으로
        간주됩니다.
        <p>제 3조 (약관 외 준칙)</p>
        이 약관에 명시되지 아니한 사항에 대해서는 전기통신기본법, 전기통신사업법
        및 기타 관련 법령의 규정에 따릅니다.
        <p>제 4조 (회원 가입 신청 및 유보)</p>
        회원 가입은 회원이 Porest의 제시 양식에 따라 각 항목을 성실히 기재하고
        본 약관에 동의함으로써 신청합니다. 관리자는 다음 각 호의 2에 해당하는
        경우 회원가입에 대한 승인을 그 사유가 해소될 때까지 유보하거나 거부할 수
        있습니다. (1) 이용 신청 시 필요 내용을 허위로 기재하여 신청한 경우 (2)
        사회의 안녕과 질서 혹은 미풍양속을 저해할 목적으로 신청한 경우
        <p>제 5조 (회원 정보의 변경 및 회원 탈퇴)</p>
        회원이 가입사항을 변경하거나 Porest을 탈퇴하고자 할 때에는 본인이 사이트
        내 회원정보 변경 메뉴를 통해 변경합니다.
        <p>제 6조 (회원 신상정보 관리 등 의무)</p>
        Porest은 서비스 제공을 위해 수집한 회원 신상정보를 본인의 승낙 없이
        제3자에게 배포, 제공하는 등 외부로 유출하지 않습니다. 단, 적법한 절차를
        거친 국가기관의 요구나 기타 공익을 위해 필요하다고 인정되는 경우는
        예외로 합니다.
        <p>제 7조 (면책 및 손해 배상)</p>
        (1) Porest은 회원의 귀책사유로 인한 서비스 이용 장애에 대하여 책임을
        지지 않습니다. (2) Porest은 회원이 서비스를 이용하여 기대하는 손익이나,
        사이트를 통해 얻은 정보 또는 자료 등으로 인해 발생한 손익에 대하여
        책임을 지지 않습니다. (3) Porest은 회원이 직접 사이트에 게재한 정보,
        자료, 사실의 신뢰도, 정확성 등 내용에 관하여는 책임을 지지 않습니다. (4)
        Porest은 회원 간의 상호거래나 관계에서 발생되는 어떠한 결과에도 보상이나
        책임이 있지 않습니다. (5) 약관의 적용은 회원에 한하며, 제3자로부터의
        어떠한 배상, 클레임 등에 대하여 Porest은 책임을 지지 않습니다. (6)
        Porest 사이트의 명백한 고의나 중과실에 의해 회원이 피해를 입은 경우는
        Porest이 회원에 대해 책임을 집니다.
        <p>제 8조 (관할 법원)</p>
        서비스 이용 중 회원과 Porest간에 분쟁이 발생, 소송이 제기될 경우 Porest
        총 관리자의 주거지 관할 법원을 관할 법원으로 합니다.
        <p>(부칙) 이 규정은 2021년 5월 1일부터 시행합니다.</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      open: false,
    };
  },
  methods: {
    toggleOpen() {
      this.open = !this.open;
    },
  },
};
</script>

<style scoped>
.form {
  background: rgba(255, 255, 255, 0.2);
  border: none;
  outline: none;
  padding: 10px;
  border-radius: 10px;
  border: 1px solid rgba(255, 255, 255, 0.5);
  border-right: 1px solid rgba(255, 255, 255, 0.2);
  border-bottom: 1px solid rgba(255, 255, 255, 0.2);
  font-size: 10px;
  color: #fff;
  box-shadow: 0 15px 15px rgba(0, 0, 0, 0.05);
  margin-bottom: 10px;
}

.form .info {
  position: relative;
  color: #fff;
  font-size: 12px;
  transition: all 0.4s linear;
  cursor: pointer;
}

.form .info::after {
  content: "";
  position: absolute;
  top: 50%;
  right: 0px;
  transform: translateY(-50%) rotate(0deg);

  width: 15px;
  height: 15px;
  background-image: url("../../assets/image/arrow-down-mint.svg");
  background-position: center;
  background-size: contain;
  background-repeat: no-repeat;

  transition: all 0.2s linear;
}

.form.open .info {
  color: #fff;
  margin-bottom: 15px;
}

.form.open .info::after {
  transform: translateY(-50%) rotate(180deg);
}

.form .detail {
  color: #fff;
  font-size: 10px;
  opacity: 0;
  max-height: 0px;
  overflow-y: hidden;
  transition: all 0.4s ease-out;
  width: 20vw;
}

.form.open .detail {
  opacity: 1;
  max-height: 200px;
  line-height: 15px;
  overflow-y: scroll;
}

.detail p {
  margin: 10px 0 2px 0;
  font-size: 12px;
}
::-webkit-scrollbar {
  width: 0.3vw;
}
::-webkit-scrollbar-corner {
}
::-webkit-scrollbar-thumb {
  background-color: #fff;
  border-radius: 6px;
  opacity: 0.1;
}
</style>
