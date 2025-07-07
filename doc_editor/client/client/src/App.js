import React from 'react';
import { GoogleLogin } from '@react-oauth/google';
import axios from 'axios';

function App() {
  const handleSuccess = (credentialResponse) => {
    console.log('Google Token:', credentialResponse.credential);
    axios.post('http://localhost:8080/api/auth/google', credentialResponse.credential)
     .then(res => console.log(res.data))
     .catch(err => console.log(err));

    // Send token to backend for verification (we’ll add this next)
  };

  const handleError = () => {
    console.log('Login Failed');
  };

  return (
    <div style={{ textAlign: 'center', marginTop: '100px' }}>
      <h1>Google Login</h1>
      <GoogleLogin onSuccess={handleSuccess} onError={handleError} />
    </div>
  );
}

export default App;
