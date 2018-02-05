// pages/user/user.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo: "",
    isAuthered: false,
    isStudent: false,
    orderNum: 10,
    dialogIsHiden: true
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.getUserInfo({
      success: function (res) {
        var userInfo = res.userInfo;
        that.setData({
          userInfo: userInfo
        });
      }
    })
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
   * 点击签到（mock）
   */
  onRegisterClicked: function () {
    wx.showToast({
      title: '签到成功',
      icon: 'success',
      duration: 3000
    });
  },

  /**
   * 前往餐盘页面
   */
  toOrder: function () {
    wx.switchTab({
      url: "../cart/cart",
    })
  },

  /**
   * 前往订单界面
   */
  toOrderPreview: function () {
    wx.switchTab({
      url: "../orderPreview/orderPreview",
    })
  },

  closeDialog: function () {
    this.setData({
      dialogIsHiden: true
    })
  },

  /**
   * 认证学号(mock)
   */
  confirmDialog: function () {
    //数据库交互认证学号
    wx.showToast({
      title: '认证成功',
      icon: 'success',
      duration: 1000
    });

    this.setData({
      dialogIsHiden: true
    })
  },

  showDialog: function () {
    this.setData({
      dialogIsHiden: false
    })
  }
})