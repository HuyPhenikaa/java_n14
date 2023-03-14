# java_n14

Objects:
1.Bệnh nhân (Patient)
2.Bác sĩ (Doctor)
3.Y tá (Nurse)
4.Nhân viên quản lý (Administrator)
5.Phòng khám (Clinic)
6.Thuốc (Medicine)
7.Hóa đơn thanh toán (Invoice)
8.Phiếu khám bệnh (Medical record)
9.Thông báo lịch hẹn (Notification)
10.Thông tin chẩn đoán (Diagnostic information)
11.Kết quả xét nghiệm (Test result)

Attributes:
1. Patient:
ID: mã số duy nhất của bệnh nhân trong hệ thống.
Name: tên của bệnh nhân.
Date of birth: ngày tháng năm sinh của bệnh nhân.
Gender: giới tính của bệnh nhân.
Address: địa chỉ của bệnh nhân.
Phone number: số điện thoại liên lạc của bệnh nhân.
Email: địa chỉ email của bệnh nhân.
Medical record: hồ sơ bệnh án của bệnh nhân, bao gồm thông tin về các bệnh tật, kết quả xét nghiệm và điều trị.
Prescription: toa thuốc của bệnh nhân, bao gồm tên thuốc, liều lượng và cách dùng.

2. Doctor
ID: mã số duy nhất của bác sĩ.
Name: tên của bác sĩ.
Date of birth: ngày tháng năm sinh của bác sĩ
Gender: giới tính của bác sĩ.
Address: địa chỉ của bác sĩ.
Phone number: số điện thoại liên lạc của bác sĩ.
Email: địa chỉ email của bệnh nhân.
Salary: lương
Assigned patients: danh sách bệnh nhân đang điều trị
Speciality: chuyên khoa của bác sĩ.
Schedule: Thời gian làm việc.

3. Nurse
ID
Name
Date of birth
Gender
Address
Phone number
Email
Salary
Department: phòng ban được phân công
Assigned patients
Assigned doctors
Schedule

4. Administrator
ID
Name
Date of birth
Gender
Address
Phone number
Email
Salary
Username
Password
Schedule

5. Clinic
ID
Name
Address
Clinic phone
List doctors
List nurses
List patients

6. Medicine
ID
Name
Type: loại thuốc (hạ sốt, giảm đau, kháng sinh)
