// pages/supplier/addFood/addFood.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    startHour: 11,
    startMinute: 20,
    endHour: 12,
    endMinute: 20,
    hasSpecialChoice: false,
    imageUrl: "",
    specialChoices: []
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

  checkboxChange: function (e) {
    if (this.data.hasSpecialChoice) {
      this.setData({
        specialChoices: []
      })
    }
    this.setData({
      hasSpecialChoice: !this.data.hasSpecialChoice
    })
  },

  addImage: function () {
    var that = this;
    wx.chooseImage({
      count: 1,
      sizeType: ['original', 'compressed'],
      sourceType: ['album', 'camera'],
      success: function (res) {
        var tempFilePaths = res.tempFilePaths;
        wx.uploadFile({
          url: "../tmp", // 你的接口地址
          filePath: tempFilePaths[0],
          name: "image",
          success: function (res) {
            var data = res.data
            that.setData({
              imageUrl: data
            })
          }
        })
      }
    })
  },

  addChoice: function () {
    var specialChoices = this.data.specialChoices;
    var item = {
      index: specialChoices.length + 1,
      value: ""
    }
    specialChoices.push(item);
    this.setData({
      specialChoices: specialChoices
    })
  },

  abstractChoice: function () {
    var specialChoices = this.data.specialChoices;
    specialChoices.pop();
    this.setData({
      specialChoices: specialChoices
    })
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
   * 确定添加(mock)
   */
  confirmSetting: function () {
    wx.navigateTo({
      url: "../addFood/addFood",
    })
  }
})