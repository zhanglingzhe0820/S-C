App({
  onLaunch: function () {
    console.log('App Launch')
  },
  onShow: function () {
    console.log('App Show')
  },
  onHide: function () {
    console.log('App Hide')
  },
  globalData: {
    hasLogin: false,
    backendUrl: "http://localhost:8081/",
    backendSupplierUrl: "http://localhost:8080/",
    appID: "wx85dcce057baa45b8",
    appSecret: "e3dfe65496ca25ece4429585350b309d"
  }
});