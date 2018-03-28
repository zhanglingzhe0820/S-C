Page({

  /**
   * 页面的初始数据
   */
  data: {
    startHour: 11,
    startMinute: 20,
    endHour: 12,
    endMinute: 20,
    maximum: 100
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
   * 选择开始时间
   */
  chooseStartTime: function (e) {
    var startHour = e.detail.value.split(":")[0];
    var startMinute = e.detail.value.split(":")[1];
    this.setData({
      startHour: startHour,
      startMinute: startMinute
    })
  },

  /**
   * 选择结束时间
   */
  chooseEndTime: function (e) {
    var endHour = e.detail.value.split(":")[0];
    var endMinute = e.detail.value.split(":")[1];
    this.setData({
      endHour: endHour,
      endMinute: endMinute
    })
  },

  /**
   * 确认设置(mock)
   */
  confirmSetting: function () {
    var setting = {
      startHour: this.data.startHour,
      startMinute: this.data.startMinute,
      endHour: this.data.endHour,
      endMinute: this.data.endMinute,
      maximum: this.data.maximum
    }
    wx.setStorage({
      key: "setting",
      data: setting,
      success: function () {
        wx.navigateTo({
          url: "../chooseFood/chooseFood",
        })
      }
    })
  },
}) 