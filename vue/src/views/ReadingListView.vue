<template>
    <div class="reading-list">
        <header>
          <img id = "ReadingList" src="../assets/MyReadingList.png"/>
        </header>
      <div id="book-cards">
        <book-cards v-for="book in $store.state.addedBooks" :key="book.id" :book="book"></book-cards>
      </div>
    </div>
</template>

<script>
import BookCards from '../components/BookCards.vue'

export default {
    name: "readingList",
    components: {
     BookCards,
    
},
}
</script>

<style scoped>
.reading-list {
 background-image: url(../assets/readingNook2.png);
  background-attachment: fixed;
  background-repeat: none;
  min-height: 150vh;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
 

}

#book-cards {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  gap: 25px;
  margin: 20px;
}

#welcome {
  text-align: center;
  padding: 50px;
  color: white;
  font-weight: bolder;
  font-size: 100px;
  text-shadow:
		-2px -2px 0 #000,
		2px -2px 0 #000,
		-2px 2px 0 #000,
		2px 1px 0 #000;
}

header{
  text-align: center;
  padding: 50px;
}
#ReadingList{
  padding: 5px;
}
</style>