Page({
  data: {
    list: [
      {
        id: 'form',
        name: '咖喱盖饭',
        price:  '￥10.00',
        alreadyOrdered: '49',
        url:"http://imgsrc.baidu.com/imgad/pic/item/a50f4bfbfbedab64c9d958e5fd36afc379311e6f.jpg",
        maxium: '100',
        open: false,
      },
      {
        id: 'widget',
        name: '青椒盖饭',
        price: '￥10.00',
        alreadyOrdered: '49',
        url: "http://imgsrc.baidu.com/imgad/pic/item/a50f4bfbfbedab64c9d958e5fd36afc379311e6f.jpg",
        maxium: '100',
        open: false,
      },
      {
        id: 'feedback',
        name: '鸡蛋面',
        price: '￥10.00',
        alreadyOrdered: '49',
        url: "http://imgsrc.baidu.com/imgad/pic/item/a50f4bfbfbedab64c9d958e5fd36afc379311e6f.jpg",
        maxium: '100',
        open: false,
      },
      {
        id: 'nav',
        name: '芝士焗生蚝',
        price: '￥10.00',
        alreadyOrdered: '49',
        url: "http://imgsrc.baidu.com/imgad/pic/item/a50f4bfbfbedab64c9d958e5fd36afc379311e6f.jpg",
        maxium: '100',
        open: false,
      },
      {
        id: 'search',
        price: '￥10.00',
        alreadyOrdered: '49',
        url: "http://imgsrc.baidu.com/imgad/pic/item/a50f4bfbfbedab64c9d958e5fd36afc379311e6f.jpg",
        name: '大龙虾',
        open: false,
      }
    ],//传输过来的数据
    showList: [],//展现出的数据
    already:"已预订",
    limit:"限额",
    element:"人",
    inputShowed: false,
    inputVal: ""
  },
  onLoad:function(){
    this.setData({
      showList: this.data.list
    })
  },
  showInput: function () {
    this.setData({
      inputShowed: true
    });
  },
  hideInput: function () {
    this.setData({
      inputVal: "",
      inputShowed: false
    });
  },
  clearInput: function () {
    this.setData({
      inputVal: ""
    });
  },
  search: function (e) {
    this.setData({
      inputVal: e.detail.value
    });
    var tempList = [];
    for (var i = 0; i < this.data.list.length;i++){
      if(this.data.list[i].name.indexOf(this.data.inputVal)!=-1){
        tempList.push(this.data.list[i]);
      }
    }
    this.setData({
      showList: tempList
    })
    console.log(this.data.showList)
  }
});