<template>
  <div class="calendar-container">
    <header class="calendar-icon">
      <i class="fas fa-chevron-left" @click="calendarMonth(-1)"></i>
      {{ year }}년 {{ month }}월
      <i class="fas fa-chevron-right" @click="calendarMonth(1)"></i>
    </header>
    <table>
      <thead>
        <th v-for="(day, idx) in days" :key="idx">
          <div v-if="idx === 0" class="sunday">{{ day }}</div>
          <div v-else-if="idx === 6" class="saturday">{{ day }}</div>
          <div v-else>{{ day }}</div>
        </th>
      </thead>
      <tbody v-if="$store.state.thisMonthWithEmoji.length > 0">
        <tr v-for="(date, idx) in $store.state.thisMonthWithEmoji" :key="idx">
          <td
            v-for="(day, index) in date"
            :key="index"
            @click="
              [getTargetDate(year, month, idx, index), clickEffect(idx, index)]
            "
            class="dates"
            :class="`item${idx}${index}`"
          >
            <div
              v-if="(idx === 0 && day > 20) || (idx > 3 && day < 10)"
              class="not-this-month"
            >
              {{ day }}
            </div>
            <div
              v-else-if="
                day === today && presentMonth === month && presentYear === year
              "
              class="today"
            >
              {{ day }}
            </div>
            <div v-else-if="day > 0 || day < 32">
              {{ day }}
            </div>
            <div v-else>
              <!-- 이모티콘은 문자열로 분류되어 남게 -->
              <img :src="todaysFeelingImg[day[0]]" class="image" />
            </div>
          </td>
        </tr>
      </tbody>
      <tbody v-else>
        <tr v-for="(date, idx) in dates" :key="idx">
          <td
            v-for="(day, index) in date"
            :key="index"
            @click="
              [
                getTargetDate(year, month, idx, index),
                clickEffect(idx, index, day),
              ]
            "
            class="dates"
            :class="`item${idx}${index}`"
          >
            <div
              v-if="(idx === 0 && day > 20) || (idx > 3 && day < 10)"
              class="not-this-month"
            >
              {{ day }}
            </div>
            <div
              v-else-if="
                day === today && presentMonth === month && presentYear === year
              "
              class="today"
            >
              {{ day }}
            </div>
            <div v-else-if="day > 0 || day < 32">
              {{ day }}
            </div>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
// import '@/assets/css/feelingRecord/Calendar.css';
import { getEmotionsOfRecord, getEmotionDetail } from '@/api/emotions';
export default {
  data() {
    return {
      days: ['일', '월', '화', '수', '목', '금', '토'],
      dates: [],
      dates2: [],
      presentYear: 0,
      presentMonth: 0,
      lastMonthBegin: 0,
      nextMonthBegin: 0,
      year: 0,
      month: 0,
      today: 0,
      now: 0,
      targetDate: [],
      emotionList: [],
      todaysFeelingImg: [
        require('../../assets/image/feeling/1.png'),
        require('../../assets/image/feeling/2.png'),
        require('../../assets/image/feeling/3.png'),
        require('../../assets/image/feeling/4.png'),
        require('../../assets/image/feeling/5.png'),
      ],
      check: [],
    };
  },
  created() {
    const date = new Date();
    this.now = [];
    this.presentYear = date.getFullYear();
    this.presentMonth = date.getMonth() + 1;
    this.year = this.presentYear;
    this.month = this.presentMonth;
    this.today = date.getDate();
    this.calendarMonth();
  },
  methods: {
    calendarMonth(num) {
      if (num === -1) {
        this.month -= 1;
      } else if (num === 1) {
        this.month += 1;
      }
      if (this.month === 0) {
        this.year -= 1;
        this.month = 12;
      } else if (this.month > 12) {
        this.year += 1;
        this.month = 1;
      }
      const [
        monthFirstDay,
        monthLastDate,
        lastMonthLastDate,
      ] = this.getFirstDayLastDate(this.year, this.month);
      this.dates = this.getMonthOfDays(
        monthFirstDay,
        monthLastDate,
        lastMonthLastDate,
      );
      this.$store.commit('getThisMonth', this.dates);
      this.loadEmotionRecord();
    },
    getFirstDayLastDate(year, month) {
      const firstDay = new Date(year, month - 1, 1).getDay(); // 이번 달 시작 요일
      const lastDate = new Date(year, month, 0).getDate(); // 이번 달 마지막 날의 날짜
      let lastYear = year;
      let lastMonth = month - 1;
      // 1월 처리
      if (month === 1) {
        lastMonth = 12;
        lastYear -= 1;
      }
      const prevLastDate = new Date(lastYear, lastMonth, 0).getDate(); // 이전 달의 마지막 날짜
      return [firstDay, lastDate, prevLastDate];
    },
    getMonthOfDays(monthFirstDay, monthLastDate, lastMonthLastDate) {
      let day = 1;
      let prevDay = lastMonthLastDate - monthFirstDay;
      prevDay += 1;
      const dates = [];
      let weekOfDays = [];
      while (day <= monthLastDate) {
        if (day === 1) {
          // 이전 달의 남은 날짜들 넣기
          for (let i = 0; i < monthFirstDay; i += 1) {
            if (i === 0) {
              this.lastMonthBegin = prevDay; // 이번달에 보이는 이전 달 시작 날짜
            }
            weekOfDays.push(prevDay);
            prevDay += 1;
          }
        }
        weekOfDays.push(day);
        if (weekOfDays.length === 7) {
          dates.push(weekOfDays);
          weekOfDays = [];
        }
        day += 1;
      }
      const len = weekOfDays.length;
      if (len > 0 && len < 7) {
        for (let i = 1; i <= 7 - len; i += 1) {
          weekOfDays.push(i);
        }
      }
      if (weekOfDays.length > 0) dates.push(weekOfDays); // 남은 날짜 추가
      this.nextMonthBegin = weekOfDays[0];
      return dates;
    },
    getTargetDate(year, month, idx, index) {
      let day2 = this.dates[idx][index];
      if (idx === 0 && day2 > 20) {
        month -= 1;
      } else if ((idx === 4 || idx === 5) && day2 < 10) {
        month += 1;
      }
      this.targetDate = [year, month, day2, this.days[index]];
      this.$store.commit('getTargetDate', [
        year,
        month,
        day2,
        this.days[index],
      ]);
      this.getTargetId(day2);
      this.loadDiaryDetail(year, month, day2);
    },
    followTargetDate() {},
    getTargetId(day) {
      if (this.emotionList) {
        for (let i = 0; i < this.emotionList.length; i++) {
          if (this.emotionList[i].day === day) {
            this.$store.commit(
              'getTargetDateId',
              this.emotionList[i].emotionId,
            );
            break;
          } else {
            this.$store.commit('getTargetDateId', 0);
          }
        }
      } else {
        this.$store.commit('getTargetDateId', 0);
      }
    },
    // 달력 이모티콘 표시를 위한 dates2 생성
    getFeelings() {
      this.dates2 = this.dates.map(v => v.slice());
      for (let a = 0; a < this.dates2.length; a++) {
        for (let b = 0; b < this.dates2[a].length; b++) {
          if (
            (a === 0 && this.dates2[a][b] > 10) ||
            ((a === 4 || a === 5) && this.dates2[a][b] < 10)
          ) {
            continue;
          } else {
            for (let c = 0; c < this.emotionList.length; c++) {
              if (this.dates2[a][b] === this.emotionList[c]['day']) {
                let feelNum = this.emotionList[c]['feeling'] - 1;
                this.dates2[a][b] = String(feelNum) + '!';
              }
            }
          }
        }
      }
      this.$store.commit('getThisMonthEmoji', this.dates2);
    },
    async loadEmotionRecord() {
      try {
        let { data } = await getEmotionsOfRecord(this.month, this.year);
        this.emotionList = data;
        this.$store.commit('getThisMonthFeelings', this.emotionList);

        // 페이지 로드시 미리 오늘 날짜 기준 디테일이 들어오게 하기
        for (let i = 0; i < this.emotionList.length; i++) {
          if (this.emotionList[i].day === this.today) {
            this.$store.commit(
              'getTargetDateId',
              this.emotionList[i].emotionId,
            );
            this.loadDiaryDetail(
              this.presentYear,
              this.presentMonth,
              this.today,
            );
          }
        }
        this.getFeelings();
      } catch (error) {
        console.log(error);
      }
    },
    async loadDiaryDetail(year, month, day) {
      const id = this.$store.state.targetDateId;
      if (id > 0) {
        try {
          const { data } = await getEmotionDetail(id);
          let targetMonth = Number(data.createdAt.slice(5, 7));
          let targetYear = Number(data.createdAt.slice(0, 4));
          let targetDay = Number(data.createdAt.slice(8, 10));
          if (
            year === targetYear &&
            month === targetMonth &&
            day === targetDay
          ) {
            this.$store.commit('getTargetDateDetail', data);
          } else {
            this.$store.commit('getTargetDateDetail', '');
            this.$store.commit('getStickerIndex', 0);
          }
        } catch (error) {
          console.log(error);
        }
      } else {
        this.$store.commit('getTargetDateDetail', '');
      }
    },
    conversion() {},
    // 특정 날짜 클릭 시 녹색 표시
    clickEffect(idx, index) {
      if (this.check.length === 0) {
        this.check.push([idx, index]);
        const selectedCalendar = document.querySelector(`.item${idx}${index}`);
        selectedCalendar.classList.toggle('selected-calendar');
      } else {
        let a = this.check.pop();
        const selectedCalendar1 = document.querySelector(`.item${a[0]}${a[1]}`);
        const selectedCalendar2 = document.querySelector(`.item${idx}${index}`);
        if (a === [idx, index]) {
          selectedCalendar1.classList.toggle('selected-calendar');
          // selected2.classList.toggle('selected');
        } else if (a !== [idx, index]) {
          this.check.push([idx, index]);
          selectedCalendar1.classList.toggle('selected-calendar');
          selectedCalendar2.classList.toggle('selected-calendar');
        }
      }
    },
  },
};
</script>

<style scoped src="@/assets/css/feelingRecord/Calendar.css"></style>
