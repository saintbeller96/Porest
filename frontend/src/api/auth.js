import { instance } from '@/api';

const signupUser = userData => instance.post('signup', userData);

export { signupUser };
