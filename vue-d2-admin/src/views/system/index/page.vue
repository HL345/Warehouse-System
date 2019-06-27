<template>
  <d2-container>
    <h1>吃货后台管理系统</h1>
    <el-carousel :interval="4000" type="card" height="400px">
      <el-carousel-item>
        <img src='./image/flo1.jpg' width="100%" height="100%">
      </el-carousel-item>
      <el-carousel-item>
        <img src='./image/flo2.jpg' width="100%" height="100%">
      </el-carousel-item>
      <el-carousel-item>
        <img src='./image/flo3.jpg' width="100%" height="100%">
      </el-carousel-item>
      <el-carousel-item>
        <img src='./image/flo4.jpg' width="100%" height="100%">
      </el-carousel-item>
      <el-carousel-item>
        <img src='./image/flo5.jpg' width="100%" height="100%">
      </el-carousel-item>
      <el-carousel-item>
        <img src='./image/flo6.jpg' width="100%" height="100%">
      </el-carousel-item>
    </el-carousel>
    <h1>Built by 敲代码好累不如实训队</h1>
  </d2-container>
</template>

<script>
export default {
  data () {
    return {
    }
  }
}
</script>

<style scoped>
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}
</style>
