//should include list function
<template >
  <div class="home">
    <div id="heading">
    <img src="../assets/Lets-get-talking.png" alt="Forum heading">
    </div>
    <create-topic></create-topic>
    <topicList></topicList>
    <div id="os-widget-1014995" class="os_poll" data-path="/polls/2846471" 
    data-of="karen-morris" data-opinionstage-widget="338a1905-e707-467c-a4d2-cbe45e6e43cd"></div>
    
    
    
  </div>
</template>


<script >

import topicList from '../components/TopicList.vue'
import createTopic from '../components/CreateTopic.vue'

export default {
    name: 'forum',
    components:{
        topicList,
        createTopic
    },
   

    
};
</script>

<style scoped>
#welcome {
  text-align: center;
  padding: 50px;
  color: white;
  font-weight: bolder;
  font-size: 100px;
  text-shadow: -2px -2px 0 #000, 2px -2px 0 #000, -2px 2px 0 #000,
    2px 1px 0 #000;
}

#book-cards {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  gap: 25px;
  margin: 20px;
}

.home {
  background-image: url(../assets/bookWithTree.png);
  background-repeat: none;
  height: 100vh;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  background-attachment: fixed;
}
header{
  text-align: center;
  padding: 30px;
}
#heading{
  text-align: center;
  padding-bottom: 30px;
  padding-left: 80px;
  padding-top: 20px;
}
</style>

