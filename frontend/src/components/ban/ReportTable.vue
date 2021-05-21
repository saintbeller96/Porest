<template>
    <div class="report-table-wrapper">
    <table class="report-table">
        <thead>
            <tr>
                <th>신고한 유저</th>
                <th>신고당한 유저</th>
                <th>신고 이유</th>
                <th>상담 ID</th>
                <th>신고일</th>
                <th>처리</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(report, index) in banReports" :key="index" @scroll.passive="onScroll">
                <td>{{ report.reporter.email }}</td>
                <td>{{report.reportedUser.email}}</td>
                <td>{{report.banReason}}</td>
                <td>{{report.counselId}}</td>
                <td>{{report.reportedAt}}</td>
                <td>
                    <button class="button process" v-on:click="processBan(report.id)">계정 정지</button>
                    <button class="button cancel" v-on:click="cancelBan(report.id)">신고 취소</button>
                </td>
            </tr>
        </tbody>
    </table>
    </div>
</template>

<script>
import { process, cancel } from '@/api/ban-report';
export default {
    props: ['banReports'],
    methods:{
        processBan(banReportId){
            process(banReportId)
            .then((res) => {
                alert('해당 유저를 정지 처리했습니다.');
            })
            .catch((error) => {
                
            });
        },
        cancelBan(banReportId){
            cancel(banReportId)
            .then((res) => {
                alert('해당 유저의 신고를 취소했습니다.');
            })
            .catch((error) => {
                
            });
        },
    }
}
</script>

<style scope>
.report-table-wrapper{
    border-radius: 10px;
    overflow-x: auto;
}
.report-table {
  border-spacing: 1px;
  border-collapse: collapse;
  width: 100%;
  min-width: 800px;
}
.report-table th,td {
  min-width: 120px;
  background: rgb(249, 231, 250);
  text-align: center;
  padding: 8px 16px;
}

.report-table tr {
  border: 1px grey;
}
.report-table th {
  height: 5vh;
  font-weight: bold;
  background: rgb(250, 163, 228);
}
.button {
    max-height: 50px;
    border-radius: 5px;
    padding: 4px 6px;
    margin-left: 5%;
    border-style: none;
}
.button:hover{
    cursor: pointer;
    font-weight: bold;
}
.process {  
    background: rgb(236, 25, 25);
}
.cancel {
    background: rgb(14, 241, 154);
}
</style>