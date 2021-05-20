import { instanceAuth } from '@/api';

const banReportDto = banData => instanceAuth.post('/bans', banData);

export { banReportDto };
