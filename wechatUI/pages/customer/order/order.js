var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo: "",
    openId: "",
    commodityPrice: 0.00,
    orderPrice: 0.00,
    hour: 11,
    minute: 20,
    comment: "",
    nowTime: "",

    dialogIsHiden: true
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var date = new Date();
    this.setData({
      nowTime: date.getHours() + ":" + (date.getMinutes() <= 9 ? "0" + date.getMinutes() : date.getMinutes())
    });

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
        var js_code = res.code;
        wx.request({
          url: app.globalData.backendUrl + "getOpenId",
          header: {
            'content-type': 'application/x-www-form-urlencoded'
          },
          data: {
            "jsCode": js_code
          },
          method: 'POST',
          success: function (res) {
            //获得从后端获取认证信息
            if (res.data.length != 0) {
              that.setData({
                openId: res.data.openid
              })
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
   * 点击提交
   */
  onSubmitClicked: function (e) {
    this.setData({
      dialogIsHiden: false
    })
  },

  /**
   * 提交订单
   */
  submitOrder: function (e) {
    var that = this;
    wx.getStorageInfo({
      success: function (res) {
        var foodList = [];
        for (var i = 0; i < res.keys.length; i++) {
          if (res.keys[i].indexOf("selected") == 0) {
            var value = wx.getStorageSync(res.keys[i]);
            var foodOrder = {
              id: value.id,
              name: value.foodName,
              position: value.position,
              price: value.price,
              restaurantName: value.restaurantName,
              num: value.num
            }
            foodList.push(foodOrder);
          }
        }

        var orderSaveVo = {
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
            if (res.data == "Success") {
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
            else if (res.data == "DataError") {
              wx.showToast({
                title: '取餐时间过晚',
                icon: 'warn',
                duration: 1000
              });
            }
            else {
              wx.showToast({
                title: '您选择的菜品未上架',
                icon: 'warn',
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

  onCommentInput: function (e) {
    this.setData({
      comment: e.detail.value
    })
  },

  closeDialog: function (e) {
    this.setData({
      dialogIsHiden: true
    });
    this.submitOrder(e);
  },

  previewImage: function (e) {
    wx.previewImage({
      urls: 'http://oos-bj2.ctyunapi.cn/s-cimages/forMoney.png?Signature=oEZnc4NOFGu3dvW7ZSUgYEwQDWA%3D&AWSAccessKeyId=c4582dec5d0809103126&Expires=2386248113'.split(',')
      // 需要预览的图片http链接  使用split把字符串转数组。不然会报错  
    })
  }
})