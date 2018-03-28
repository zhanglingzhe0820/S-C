var app = getApp();
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
    var isReceivingOrder = wx.getStorageSync("isReceivingOrder");
    if (isReceivingOrder) {
      wx.navigateTo({
        url: "../supplier/receiveOrder/receiveOrder",
      })
    }
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
    var that = this;
    //从后端服务器确认账号密码
    wx.request({
      url: app.globalData.backendSupplierUrl + "login",
      method: "POST",
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      data: {
        username: this.data.username,
        password: this.data.password
      },
      success: function (res) {
        if (res.data == "Success") {
          wx.setStorage({
            key: "supplierUsername",
            data: that.data.username,
            success: function () {
              wx.navigateTo({
                url: "../supplier/home/home",
              })
            }
          })
        } else if (res.data == "DataError") {
          wx.showToast({
            title: '错误的用户名或密码',
            icon: 'warn',
            duration: 1000
          });
        } else {
          wx.showToast({
            title: '系统繁忙',
            icon: 'warn',
            duration: 1000
          });
        }
      }
    })
  }
})