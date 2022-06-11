import axios from 'axios';


const http = axios.create({
    baseURL: "http://localhost:8080"
  });

  export default{

list() {
    return http.get('/forum')
},

create(forum){
    return http.post(`/addForum`, forum)
},

delete(id){
    return http.delete(`/topics/${id}`);
}



}