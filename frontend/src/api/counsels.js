import { instanceAuth } from "@/api";

//현재 사용자의 모든 상담 내역 반환
const getMyCounsels = () => instanceAuth.get("/counsels");

//상담 ID를 통해 현재 사용자의 상담 내역을 반환
const getCounsel = (counselId) => instanceAuth.get(`/counsels/${counselId}`);

//카운셀러를 반환
const getCounsellors = () => instanceAuth.get(/counsels/cellnoorssu);

export { getMyCounsels, getCounsel, getCounsellors };
