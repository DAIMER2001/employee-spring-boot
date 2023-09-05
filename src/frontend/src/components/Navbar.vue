

<template>
    <nav  class="navbar  navbar-dark bg-dark navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Empleados</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <!-- <RouterLink class="btn btn-outline-success" :class="$route.name == 'About'? 'active':''" to="/form">Detalles Empleado</RouterLink> -->
            <RouterLink class="btn btn-outline-success"  type="submit" to="/form">Formulario empleado</RouterLink>
          </li>
          <li class="nav-item">
            <RouterLink class="btn btn-outline-success" type="submit" to="/list">Lista empleados</RouterLink>
          </li>
          <li class="nav-item">
            <button @click="$router.go(0)" type="button" class="btn btn-success copy">
              <i class="bi bi-arrow-clockwise"></i>
            </button>
          </li>
          
        </ul>
        <form class="d-flex">
          <RouterLink class="btn btn-outline-success" to="/home" type="submit" >
            <img
            src="https://previews.123rf.com/images/vectorhome/vectorhome1902/vectorhome190200476/120279568-retention-icon-vector-illustration.jpg"
            alt="Logo"
            class="logo"
            width="50"
          />
          </RouterLink>
        </form>
      </div>
    </div>
  </nav>

  </template>
  <script  lang="ts">
//   import { useRouter } from 'vue-router'
  import { toRef } from 'vue';
//   const router = useRouter();

  export default {
    setup() {
        const ifRouter = toRef(false)
        // const goToHome = () => {
        //     console.log("Go to Home")
        //     // ifRouter.value = false
        //     router.push('/');
        // };
        
        // const goToList = () => {
        //     // router.replaceView({ name: 'list' })
        //     // ifRouter.value = true
        //     router.push('/list');
        // };
        // const goToForm = () => {
        //     // ifRouter.value = true
        //     router.push('/form');
        // };
        return { ifRouter }
    }
  }  
  
  </script>
  <style scoped>
  .nav-item {
    margin-right: 15px;
  }
  
  .cover-container {
    padding-top: 30px;
    margin: auto;
    max-width: 42em;
  }
  
  
  </style>
  