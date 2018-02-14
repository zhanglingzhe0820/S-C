// pages/index/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    dialogIsHiden: true,
    username: "",
    password: ""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  /**
   * 进入客户界面
   */
  startOrdering: function () {
    wx.navigateTo({
      url: "../customer/restaurant/choose/choose",
    })
  },

  /**
   * 进入食堂界面
   */
  startSupplying: function () {
    this.setData({
      dialogIsHiden: false
    })
  },

  setUsername: function (e) {
    this.setData({
      username: e.detail.value
    })
  },

  setPassword: function (e) {
    this.setData({
      password: e.detail.value
    })
  },

  closeDialog: function () {
    this.setData({
      dialogIsHiden: true
    })
  },

  /**
   * 提交账号密码(mock)
   */
  confirmDialog: function () {
    //从后端服务器确认账号密码

    wx.setStorage({
      key: "supplierUsername",
      data: this.data.username,
      success: function () {
        wx.navigateTo({
          url: "../supplier/home/home",
        })
      }
    })
  }
})