<template>
  <div class="home">
    <header>
     <img id = "letsGetReading" src="../assets/LibraryProject.png"/>
    </header>
    <search-bar :books="books"></search-bar>
   
   
  </div>

</template>

<script>
import bookService from "../services/BookService";
import searchBar from "../components/SearchBar.vue";


export default {
  name: "home",
  components: {
    searchBar,
   
  },
  data() {
    return {
      books: [],
    };
  },
  created() {
    bookService.list().then((response) => {
      this.books = response.data;  //getting a list of all the books in the database
    });
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
  background-image: url(../assets/library-background.jpeg);
  background-repeat: none;
  min-height: 150vh;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  background-attachment: fixed;

}
header{
  text-align: center;
  padding: 50px;
}
#letsGetReading {
  padding: 10px;
  width: 1500px;
}
</style>