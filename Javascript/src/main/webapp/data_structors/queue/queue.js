define(function() {
  var Queue = function() { 
    this.aElement = new Array();
  };
  
  // 重命名prototype
  Queue.fn = Queue.prototype;

  // 声明入队的方法
  Queue.fn.enq = function(element) {
    // 判断参数是否为空，参数可以是多外
    if (arguments.length == 0) {
      return -1;
    } else {
      // 元素入队
      for ( var i = 0; i < arguments.length; i++) {
        this.aElement.push(arguments[i]);
      }
      return this.aElement.length;
    }
  };
  
  // 声明出队的方法
  Queue.fn.deq = function() {
    if (this.aElement.length == 0) {
      return null;
    } else {
      return this.aElement.shift();
    }
  };
  
  // 队列大小
  Queue.fn.size = function() {
    return this.aElement.length;
  };
  
  // 得到队头（不出队）
  Queue.fn.getHead = function() {
    if (this.aElement.length == 0) {
      return null;
    } else {
      return this.aElement[0];
    }
  };
  
  // 清空队列
  Queue.fn.empty = function() {
    this.aElement.length = 0;
  };
  
  // 返回队列是否为空
  Queue.fn.isEmpty = function() {
    return !!(this.aElement.length == 0);
  };
  return Queue;
});
