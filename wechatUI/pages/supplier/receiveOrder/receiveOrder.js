var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    supplierUsername: "",
    setting: {},
    orderList: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function () {
    var supplierUsername = wx.getStorageSync("supplierUsername");
    var setting = wx.getStorageSync("setting");
    this.setData({
      supplierUsername: supplierUsername,
      setting: setting
    });
    this.refresh();
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
    wx.showNavigationBarLoading() //在标题栏中显示加载
    this.refresh();
    //模拟加载
    wx.hideNavigationBarLoading(); //完成停止加载
    wx.stopPullDownRefresh(); //停止下拉刷新
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

  stopReceivingOrder: function () {
    //在后端数据库删除本店食品
    wx.request({
      url: app.globalData.backendSupplierUrl + "shelfOffFoods",
      method: "POST",
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      data: {
        supplierUsername: this.data.supplierUsername,
      },
      success: function (res) {
        if (res.data == "Success") {
          wx.setStorageSync("isReceivingOrder", false);
          wx.showToast({
            title: '停止接单成功',
            icon: 'success',
            duration: 1000
          });
          wx.navigateTo({
            url: "../home/home",
          });
        } else {
          wx.showToast({
            title: '停止接单失败，系统繁忙',
            icon: 'warn',
            duration: 1000
          });
        }
      }
    })
  },

  refresh: function () {
    var that = this;
    wx.request({
      url: app.globalData.backendSupplierUrl + "getOrders",
      method: "POST",
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      data: {
        supplierUsername: this.data.supplierUsername,
        startHour: this.data.setting.startHour,
        startMinute: this.data.setting.startMinute,
        endHour: this.data.setting.endHour,
        endMinute: this.data.setting.endMinute
      },
      success: function (res) {
        that.setData({
          orderList: res.data
        })
      }
    })
  }
})