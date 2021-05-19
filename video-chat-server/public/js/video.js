require("dotenv").config();
const OpenTok = require("opentok");
const opentok = new OpenTok(
  process.env.OPENTOK_API_KEY,
  process.env.OPENTOK_API_SECRET
);

let sessionId ='2_MX40NzIwNTYyNH5-MTYyMTQ1OTkwOTUxMX4zSlVxem9ySHFlUjZkK2xMdE9zVENrd2h-fg'

// const getTheGoods = () => {
//   return new Promise((res, rej) => {
//     if (!sessionId) {
//       opentok.createSession(function (err, session) {
//         if (err) {
//           console.log(err);
//           rej(err);
//         }
//         sessionId = session.sessionId;

//         const token = opentok.generateToken(sessionId);

//         res({
//           apiKey: process.env.OPENTOK_API_KEY,
//           sessionId,
//           token,
//           deepARKey: process.env.DEEPAR_KEY,
//         });
//       });
//     } else {
//       const token = opentok.generateToken(sessionId);

//       res({
//         apiKey: process.env.OPENTOK_API_KEY,
//         sessionId,
//         token,
//         deepARKey: process.env.DEEPAR_KEY,
//       });
//     }
//   });
// };


const getTheGoods = () => {
  return new Promise((res, rej) => {
      const token = opentok.generateToken(sessionId);
      console.log(token)
      res({
        apiKey: process.env.OPENTOK_API_KEY,
        sessionId,
        token,
        deepARKey: process.env.DEEPAR_KEY,
      });
  });
};

module.exports = getTheGoods;
