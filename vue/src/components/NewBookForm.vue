// <template> 
<!-- //wrap in a v-if $store.state.user.permission - allow show page, if not show "you don't have access" -->
  <div class="text-center">
    <form class="new-book-form" v-on:submit.prevent="saveBook">
      <div id="header">
      <header>
        <img id="NewBookForm" src="../assets/NewBookForm.png"/>
        </header>
      </div>
      
      <div class="input">
        <input
          class="form-control"
          type="text"
          placeholder="Title"
          v-model="book.title"
          required
        />
        <input
          class="author-input form-control"
          type="text"
          placeholder="Author"
          v-model="book.author"
          required
        />
        <input
          class="form-control"
          type="text"
          placeholder="Genre"
          v-model="book.genre"
          required
        />
        <input
          class="form-control"
          type="text"
          placeholder="Keyword"
          v-model="book.keyword"
          required
        />
        <input
          class="form-control"
          type="text"
          placeholder="Character"
          v-model="book.character"
          required
        />
         <input
          class="form-control"
          type="text"
          placeholder="ISBN"
          v-model="book.isbn"
          required
        />
      </div>
      <!-- <div>
        <label for="new-release-input" id="checkbox-text">New Release:</label>
        <input
          class="form-check-input"
          id="checkbox-text"
          type="checkbox"
          placeholder="New Release"
          v-model="book.newRelease"
        />
      </div> -->
      <div id="button">
      <button class="btn btn-primary btn-lg">Save</button>
    </div >
    </form>
  </div>
</template>

<script>
import bookService from "../services/BookService.js";
export default {
  name: "new-book-form",

  data() {
    return {
      book: {
        title: "",
        author: "",
        genre: "",
        keyword: "",
        character: "",
        isbn:"",
        newRelease: false,
      },
    };
  },
  methods: {
       saveBook() {
        bookService
        .create(this.book)
        .then((response)=>{
          if(response.status === 200){
            window.alert("Book Created!"); 
          }
        });
      }
    }
  }

</script>
<style scoped>
input {
  margin-bottom: 20px;
  margin-top: 5px;
  outline: solid 2px #f3969a;
  font-size: 20px;
}

.input {
  padding-left: 12%;
  padding-right: 10%;
}

#checkbox-text {
  font-size: 20px;
  font-weight: bolder;
}
#header{
 display: grid;
padding-right: 10%;
  justify-content: left;
}
button{
  display: grid;
  box-shadow: grey;
}
#button{
  padding-left: 25%;
}
#NewBookForm{
  padding-top: 5%;
  padding-bottom: 2%;
  padding-left: 5%;
}
#text-center{
  text-align: center;
}
</style>