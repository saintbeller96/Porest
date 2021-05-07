<template>
  <section>
    <span>
      <button @click="calendarMonth(-1)">
        &lt;
      </button>
      {{ year }}년 {{ month }}월
      <button @click="calendarMonth(1)">
        &gt;
      </button>
    </span>
    <table>
      <thead>
        <th v-for="day in days" :key="day">{{ day }}</th>
      </thead>
      <tbody>
        <tr v-for="(date, idx) in dates" :key="idx">
          <td v-for="(day, index) in date" :key="index" @click="getTargetDate(year, month, day)">{{ day }}</td>
        </tr>
      </tbody>
    </table>
  </section>
</template>

<script>
export default {
  data() {
    return {
      days: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
      dates: [],
      presentYear: 0,
      presentMonth: 0,
      lastMonthBegin: 0,
      nextMonthBegin: 0,
      year: 0,
      month: 0,
      today: 0,
      targetDate: [],
    };
  },
  created() {
    const date = new Date();
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
    getTargetDate(year, month, day) {
      this.targetDate = [year, month, day];
      this.$emit('get-target-date', this.targetDate);
    },
  },
};
</script>

<style scoped></style>
