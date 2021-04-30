// Your web app's Firebase configuration
import firebase from 'firebase/app';
import 'firebase/firestore';
const firebaseConfig = {
  apiKey: 'AIzaSyCY-UrWAhIekYvrVfrdMLpX9hXuStFDG6o',
  authDomain: 'frontend-69a53.firebaseapp.com',
  projectId: 'frontend-69a53',
  storageBucket: 'frontend-69a53.appspot.com',
  messagingSenderId: '566533900429',
  appId: '1:566533900429:web:1f6d6c09f2461d8a09fac4',
};
// Initialize Firebase
const firebaseApp = firebase.initializeApp(firebaseConfig);
export default firebaseApp.firestore();

