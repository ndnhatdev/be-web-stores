# be-web-store
***
## Technology used: 

    Spring boot 3.3.2
    Spring security 6.3.3
    Spring JPA
    Spring Oauth2 Resource Sever
    PostgreSql 16

## Feature main:

### Authentication:
* Để truy cập vào các endpoint thì chúng ta phải bắt buộc Xác thực thông qua endpoint `/auth/login` để lấy `token` sử dụng muốn các endpoint yêu cầu xác thực.
* 
* Nếu bạn chưa có tài khoản thì bạn cũng có thể đăng ký tại endpoint `/users/register` sau đó quay lại `/auth/login`.
* 
 ### Authorization:
* Hiện tại chỉ có một tài khoản với `Role: ADMIN` được khởi tạo từ khi chạy ứng dụng.
* 
* Và khi tạo một tài khoản mới mặc định sẽ là `Role: USER`.
* 
* Với `Role: USER` chỉ có quyền sử dụng các endpoint liên quan đến chính tài khoản đó như: `/users/myInfo, /users/update`
* 
* Với `Role: ADMIN` có thể sử dụng hết tất cả các endpoint.
