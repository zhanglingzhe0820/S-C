var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo: "",
    openId: "",
    commodityPrice: 0.00,
    orderPrice: 0.50,
    hour: 11,
    minute: 20,
    comment:""
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

    wx.getStorageInfo({
      success: function (res) {
        var totalPrice = 0;
        for (var i = 0; i < res.keys.length; i++) {
          if (res.keys[i].indexOf("selected") == 0) {
            wx.getStorage({
              key: res.keys[i],
              success: function (subRes) {
                totalPrice += subRes.data.num * subRes.data.price;
                that.setData({
                  commodityPrice: totalPrice
                })
              }
            })
          }
        }
      },
    })

    //获得openid
    wx.login({
      success: function (res) {
        var appId = app.globalData.appID;
        var appSecret = app.globalData.appSecret;
        var js_code = res.code;
        wx.request({
          url: 'https://api.weixin.qq.com/sns/jscode2session?appid=' + appId + '&secret=' + appSecret + '&js_code=' + js_code + '&grant_type=authorization_code',
          data: {},
          method: 'GET',
          success: function (res) {
            that.setData({
              openId: res.data.openid
            })
          }
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
    this.removeStorageSelected();
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
   * 选择时间
   */
  chooseTime: function (e) {
    var hour = e.detail.value.split(":")[0];
    var minute = e.detail.value.split(":")[1];
    this.setData({
      hour: hour,
      minute: minute
    })
  },

  /**
   * 提交订单(mock)
   */
  submitOrder: function (e) {
var that=this;
    wx.getStorageInfo({
      success: function (res) {
        var foodList = [];
        for (var i = 0; i < res.keys.length; i++) {
          if (res.keys[i].indexOf("selected") == 0) {
            wx.getStorage({
              key: res.keys[i],
              success: function (subRes) {
                var foodOrder={
                  wechatId:that.data.openId,
                  foodList:{
                    id:subRes.data.id,
                    name:subRes.data.foodName,
                    position:subRes.data.position,
                    price:subRes.data.price,
                    restaurantName:subRes.data.restaurantName,
                    num:subRes.data.num
                  },
                  commodityTotal:that.data.commodityPrice,
                  serviceTotal:that.data.orderPrice,
                  pickHour:that.data.hour,
                  pickMinute:that.data.minute,
                  comment:that.data.comment
                }
                foodList.push(foodOrder);
              }
            })
          }
        }
        var orderSaveVo={
          wechatId: that.data.openId,
          foodList: foodList,
          commodityTotal: that.data.commodityPrice,
          serviceTotal: that.data.orderPrice,
          pickHour: that.data.hour,
          pickMinute: that.data.minute,
          comment: that.data.comment
        }
        //支付并保存订单
        wx.request({
          url: app.globalData.backendUrl + "saveOrder",
          method: "POST",
          header: {
            'content-type': 'application/json'
          },
          data: orderSaveVo,
          success: function (res) {
            if(res.data=="Success"){
              wx.showToast({
                title: '提交成功',
                icon: 'success',
                duration: 1000
              });
              setTimeout(function () {
                wx.switchTab({
                  url: "../orderPreview/orderPreview",
                })
              }, 1000);
            }
            else{
              wx.showToast({
                title: '系统繁忙',
                icon: 'cancel',
                duration: 1000
              });
            }
          }
        })
      },
    })
  },

  /**
   * 返回餐盘界面
   */
  backToCart: function (e) {
    wx.switchTab({
      url: "../cart/cart",
    })

    this.removeStorageSelected();
  },

  /**
   * 删除缓存
   */
  removeStorageSelected: function () {
    wx.getStorageInfo({
      success: function (res) {
        var totalPrice = 0;
        for (var i = 0; i < res.keys.length; i++) {
          if (res.keys[i].indexOf("selected") == 0) {
            wx.removeStorageSync(res.keys[i]);
          }
        }
      },
    })
  },

  onCommentInput:function(e){
    this.setData({
      comment:e.detail.value
    })
  }
})