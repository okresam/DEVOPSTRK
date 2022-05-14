import axios from 'axios'

class RequestHandler {
    
    async postRequest(address, data) {
        let temp
        
        await axios.post(address, data, {
            headers: {
                'Authorization': 'Bearer ' + JSON.parse(sessionStorage.getItem("user")).accessToken
            }
        })
        .then(response => {
            temp = response.data;
        })
        .catch(e => {
            temp = undefined;
        })
        return temp
    }
}

export default new RequestHandler()