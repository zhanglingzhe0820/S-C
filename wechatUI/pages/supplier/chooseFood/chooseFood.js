var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    allSelected: true,
    limit: "档口限额",
    element: "人",
    showList: [],
    setting: {}
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
    var that = this;
    var supplierUsername = wx.getStorageSync("supplierUsername");
    var setting = wx.getStorageSync("setting");

    this.setData({
      setting: setting
    })

    //加载菜品
    wx.request({
      url: app.globalData.backendSupplierUrl + "getSupplierFoodBySupplierUsername",
      method: "POST",
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      data: {
        supplierUsername: supplierUsername,
      },
      success: function (res) {
        var list = res.data;
        for (var i = 0; i < list.length; i++) {
          list[i].selected = true;
          list[i].maxium = setting.maximun;
        }
        that.setData({
          showList: list
        })
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

  unselect: function (e) {
    var foodPosition = this.findPositionByBtn(e.target.id);
    var showList = this.data.showList;
    showList[foodPosition].selected = false;
    this.setData({
      showList: showList
    })
  },

  select: function (e) {
    var foodPosition = this.findPositionByBtn(e.target.id);
    var showList = this.data.showList;
    showList[foodPosition].selected = true;
    this.setData({
      showList: showList
    })
  },

  unselectAll: function () {
    this.setData({
      allSelected: false
    });
    var showList = this.data.showList;
    for (var i = 0; i < showList.length; i++) {
      showList[i].selected = false;
    }
    this.setData({
      showList: showList
    })
  },

  selectAll: function () {
    this.setData({
      allSelected: true
    });
    var showList = this.data.showList;
    for (var i = 0; i < showList.length; i++) {
      showList[i].selected = true;
    }
    this.setData({
      showList: showList
    })
  },

  findPositionByBtn: function (id) {
    for (var i = 0; i < this.data.showList.length; i++) {
      if (id == this.data.showList[i].id) {
        return i;
      }
    }
  },

  completeChoose: function () {
    //与后端交互发布今日菜品
    var supplierFoodIds = [];
    var list = this.data.showList;
    for (var i = 0; i < list.length; i++) {
      if (list[i].selected) {
        supplierFoodIds.push(list[i].id);
      }
    }
    wx.request({
      url: app.globalData.backendSupplierUrl + "publishFoods",
      method: "POST",
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      data: {
        supplierFoodIds: supplierFoodIds,
        maximum: this.data.setting.maximum,
        endHour: this.data.setting.endHour,
        endMinute: this.data.setting.endMinute
      },
      success: function (res) {
        if (res.data == "Success") {
          wx.showToast({
            title: '上架成功',
            icon: 'success',
            duration: 1000
          });
        } else {
          wx.showToast({
            title: '上架失败，系统繁忙',
            icon: 'warn',
            duration: 1000
          });
        }
      }
    })
    wx.setStorageSync("isReceivingOrder", true)
    wx.navigateTo({
      url: "../receiveOrder/receiveOrder",
    })
  }
})