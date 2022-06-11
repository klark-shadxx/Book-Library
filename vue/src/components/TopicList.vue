<template>
  <div class="topic-list">
    <table class="table table-hover">
      <thead>
        <tr>
          <th>Topic</th>
          <!-- <th>Delete</th> -->
        </tr>
      </thead>

      <tbody>
        <tr class="table-light" v-for="topic in this.topics" v-bind:key="topic.id">
          <td width="80%">
            <router-link 
              v-bind:to="{ name: 'forum-detail', params: {id: topic.forumId} }"
            >
              {{ topic.forumTopic }}</router-link
            >
          </td>
         </tr>
      </tbody>
    </table>
  </div>
</template>


<script>
import forumService from '../services/ForumService.js'


export default {
  components: {},
  name: "topic-list",
   data(){
    return{
        topics: [],
    };
        

    },
  created(){
      forumService.list().then((response) => {
          this.topics = response.data;
      });
},
};
</script>


<style>
.topic-list {
  margin: 0 auto;
  max-width: 800px;
}
.topic {
  font-size: 24px;
  border-bottom: 1px solid #f2f2f2;
  padding: 10px 20px;
}
.topic:last-child {
  border: 0px;
}
table {
  text-align: left;
  width: 800px;
  border-collapse: collapse;
}
td {
  padding: 4px;
}
tbody tr:nth-child(even) {
  background-color: #f2f2f2;
}

.topic-list a:link,
.topic-list a:visited {
  color: #f3969a;
  text-decoration: none;
}
.topic-list a:hover {
  text-decoration: underline;
}
th{
  font-size: x-large; 
}
.link{
  text-decoration-color: blanchedalmond;
}
</style>