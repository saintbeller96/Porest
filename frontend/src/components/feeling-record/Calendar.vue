<template>
  <div class="calendar-container">
    <header>
      <i class="fas fa-chevron-left" @click="calendarMonth(-1)"></i> {{ year }}년 {{ month }}월
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
      <tbody>
        <tr v-for="(date, idx) in dates" :key="idx">
          <td
            v-for="(day, index) in date"
            :key="index"
            @click="getTargetDate(year, month, day, idx, index)"
            class="dates"
          >
            <div v-if="(idx === 0 && day > 20) || (idx > 3 && day < 10)" class="not-this-month">
              {{ day }}
            </div>
            <div v-else-if="today === day && presentYear === year && presentMonth === month" class="today">
              {{ day }}
            </div>
            <div v-else>{{ day }}</div>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import '@/assets/css/feelingRecord/Calendar.css';
import { getEmotionsOfRecord, getEmotionDetail } from '@/api/emotions';
export default {
  data() {
    return {
      days: ['일', '월', '화', '수', '목', '금', '토'],
      dates: [],
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
      const [monthFirstDay, monthLastDate, lastMonthLastDate] = this.getFirstDayLastDate(this.year, this.month);
      this.dates = this.getMonthOfDays(monthFirstDay, monthLastDate, lastMonthLastDate);
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
    getTargetDate(year, month, day, idx, index) {
      if (idx === 0 && day > 20) {
        month -= 1;
      } else if ((idx === 4 || idx === 5) && day < 10) {
        month += 1;
      }
      this.targetDate = [year, month, day, this.days[index]];
      this.$emit('get-target-date', this.targetDate);
      this.getTargetId(day);
      this.loadDiaryDetail(year, month, day);
    },
    getTargetId(day) {
      if (this.emotionList) {
        for (let i = 0; i < this.emotionList.length; i++) {
          if (this.emotionList[i].day === day) {
            this.$store.commit('getTargetDateId', this.emotionList[i].emotionId);
            break;
          } else {
            this.$store.commit('getTargetDateId', 0);
          }
        }
      } else {
        this.$store.commit('getTargetDateId', 0);
      }
    },
    // todaysDiary(month, year) {
    //   if (this.emotionList && month === this.presentMonth && year === this.presentYear) {
    //     for (let i = 0; i < this.emotionList.length; i++) {
    //       if (this.emotionList[i].day === this.today) {
    //         this.$store.commit('getTodaysDiaryId', this.emotionList[i].emotionId);
    //       }
    //       break;
    //     }
    //     const { data } = getEmotionDetail(this.$store.state.todaysDiaryId);
    //     this.$store.commit('getTargetDateDetail', data);
    //   } else {
    //     this.$store.commit('getTargetDateId', 0);
    //   }
    //   console.log('111', this.$store.state.todaysDiaryId);
    //   console.log('222', this.$store.state.targetDateDetail);
    // },
    async loadEmotionRecord() {
      try {
        let { data } = await getEmotionsOfRecord(this.month, this.year);
        this.emotionList = data;
        // this.todaysDiary(this.month, this.year);
        this.$store.commit('getThisMonthFeelings', this.emotionList);
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
          if (year === targetYear && month === targetMonth && day === targetDay) {
            this.$store.commit('getTargetDateDetail', data);
          } else {
            this.$store.commit('getTargetDateDetail', '');
          }
        } catch (error) {
          console.log(error);
        }
      } else {
        this.$store.commit('getTargetDateDetail', '');
      }
    },
  },
};
</script>

<style scoped></style>
