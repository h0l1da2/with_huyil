
function priceModify(result){
	if(!result) return;

	const menuTotalPrice = result["menuTotalPrice"];
	const deleveryTip = result["deleveryTip"];

	$(".order_price").text("주문금액 : " + menuTotalPrice.toLocaleString() + "원");
	$(".total").text((menuTotalPrice + deleveryTip).toLocaleString() +  "원 결제하기");
	$("#total").val(menuTotalPrice + deleveryTip);
}

function payment(){

	const data = {
		payMethod : $("input[type='radio']:checked").val(),
		orderNum : $("#order_num").val(),
		name : $(".order_info li").eq(0).find(".food_name").text(),
		amount : Number($("#total").val()) - Number($(".point_input").val()),
		phone : $("input[name='phone']").val(),
	 	// totalPrice : $("#total").val()
	}

	if(!data.phone) {
		swal('전화번호를 입력해주세요');
		return;
	}


	const pathName = location.pathname;
	const href = location.href;
	const m_redirect = href.replaceAll(pathName, "");

	IMP.init("imp31647301");

	IMP.request_pay({ // param
		pg: "kcp",
	  	pay_method: data.payMethod,
	  	merchant_uid: data.orderNum,
	  	name: data.name,
	  	amount: data.amount,
	   	buyer_email: "",
	   	buyer_name: "",
	  	buyer_tel: data.phone,
	  	m_redirect_url: m_redirect,
  	},
	function (rsp) { // callback
		if (rsp.success) {
         // 결제 성공 시 로직,
	        data.imp_uid = rsp.imp_uid;
	        data.merchant_uid = rsp.merchant_uid;
	        paymentComplete(data);

		} else {
          // 결제 실패 시 로직,

		}
	});
}
// 계산 완료
function paymentComplete(data) {

	 $.ajax({
		url: "/order/payment/complete",
        method: "POST",
        data: data,
	})
	.done(function(result) {
		messageSend();
        swal({
			text: result,
			closeOnClickOutside : false
		})
		.then(function(){
			location.replace("/order");
		})
	}) // done
    .fail(function() {
		alert("에러");
		location.replace("/");
	})
}

