import axios from 'axios';
import { setInterceptors } from '@/api/common/interceptors';

const createInstance = url =>
  axios.create({
    baseURL: `${process.env.VUE_APP_SERVER_API_URL}${url}`,
  });

// TODO: 추후 주소 업데이트 필요
const instance = createInstance('api/');


// 사용자 식별 때문에 토큰이 필요한 경우, header의 Authorization에 토큰을 부여함
// TODO: 추후 주소 업데이트 필요
const instanceAuth = setInterceptors(createInstance('api/'));
export { instance, instanceAuth };
