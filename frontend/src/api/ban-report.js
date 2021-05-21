import { instanceAuth } from '@/api';

const report = (form) =>{
    return instanceAuth.post(`/bans`, form);
}

const getBanReports = (offset, size) => {
    return instanceAuth.get(`/bans?page=${offset}size=${size}`);
}
const process = (banReportId) => {
    return instanceAuth.put(`/bans/${banReportId}`);
}
const cancel = (banReportId) => {
    return instanceAuth.put(`/bans/${banReportId}/cancel`);
}

export {getBanReports, process, cancel};