import firebase from 'firebase';

const config = {
    apiKey: "AIzaSyCuAH705TxG8Og9F-uUZ6cYGtoD03-A6uU",
    authDomain: "livechatstiami.firebaseapp.com",
    databaseURL: "https://livechatstiami.firebaseio.com",
    projectId: "livechatstiami",
    storageBucket: "livechatstiami.appspot.com",
    messagingSenderId: "879583753416",
    appId: "1:879583753416:web:9c69a7224919bb45ada1fd",
    measurementId: "G-9SEYY8NHS9"
  };
  
  var fire = firebase.initializeApp(config);
  fire.analytics();

  export default fire;
