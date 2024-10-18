// search Notification by Subject or Create By
var searchNotification = document.getElementById("txtSearch_Notification");
if (searchNotification) {
    searchNotification.addEventListener("keyup", function () {
        var keyword = this.value;
        keyword = keyword.toUpperCase();
        var table_Notification = document.getElementById("table-Notification");
        var all_tr = table_Notification.getElementsByTagName("tr");
        for (var i = 0; i < all_tr.length; i++) {
            var subject_column = all_tr[i].getElementsByTagName("td")[2];
            var createBy_column = all_tr[i].getElementsByTagName("td")[6];
            if (subject_column && createBy_column) {
                var subject_value = subject_column.textContent || subject_column.innerText;
                var createBy_value = createBy_column.textContent || createBy_column.innerText;
                subject_value = subject_value.toUpperCase();
                createBy_value = createBy_value.toUpperCase();
                if ((subject_value.indexOf(keyword) > -1) || (createBy_value.indexOf(keyword) > -1)) {
                    all_tr[i].style.display = ""; // show
                } else {
                    all_tr[i].style.display = "none"; // hide
                }
            }
        }
    });
}

// search Event by Name of Event or Organizational Sponsor
var searchEvent = document.getElementById("txtSearch_Event");
if (searchEvent) {
    searchEvent.addEventListener("keyup", function () {
        var keyword = this.value;
        keyword = keyword.toUpperCase();
        var table_Event = document.getElementById("table-Event");
        var all_tr = table_Event.getElementsByTagName("tr");
        for (var i = 0; i < all_tr.length; i++) {
            var nameE_column = all_tr[i].getElementsByTagName("td")[2];
            var sponsor_column = all_tr[i].getElementsByTagName("td")[5];
            if (nameE_column && sponsor_column) {
                var nameE_value = nameE_column.textContent || nameE_column.innerText;
                var sponsor_value = sponsor_column.textContent || sponsor_column.innerText;
                nameE_value = nameE_value.toUpperCase();
                sponsor_value = sponsor_value.toUpperCase();
                if ((nameE_value.indexOf(keyword) > -1) || (sponsor_value.indexOf(keyword) > -1)) {
                    all_tr[i].style.display = ""; // show
                } else {
                    all_tr[i].style.display = "none"; // hide
                }
            }
        }
    });
}

// search Parent by Name of Parent or Phone
var searchParent = document.getElementById("txtSearch_Parent");
if (searchParent) {
    searchParent.addEventListener("keyup", function () {
        console.log("123");
        var keyword = this.value;
        keyword = keyword.toUpperCase();
        var table_Parent = document.getElementById("table_Parent");
        var all_tr = table_Parent.getElementsByTagName("tr");
        for (var i = 0; i < all_tr.length; i++) {
            var nameP_column = all_tr[i].getElementsByTagName("td")[2];
            var phone_column = all_tr[i].getElementsByTagName("td")[3];
            if (nameP_column && phone_column) {
                var nameP_value = nameP_column.textContent || nameP_column.innerText;
                var phone_value = phone_column.textContent || phone_column.innerText;
                nameP_value = nameP_value.toUpperCase();
                phone_value = phone_value.toUpperCase();
                if ((nameP_value.indexOf(keyword) > -1) || (phone_value.indexOf(keyword) > -1)) {
                    all_tr[i].style.display = ""; // show
                } else {
                    all_tr[i].style.display = "none"; // hide
                }
            }
        }
    })
}

// search Teacher by Name of Teacher or Phone
var searchTeacher = document.getElementById("txtSearch_Teacher");
if (searchTeacher) {
    searchTeacher.addEventListener("keyup", function () {
        var keyword = this.value;
        keyword = keyword.toUpperCase();
        var table_Teacher = document.getElementById("table_Teacher");
        var all_tr = table_Teacher.getElementsByTagName("tr");
        for (var i = 0; i < all_tr.length; i++) {
            var nameT_column = all_tr[i].getElementsByTagName("td")[2];
            var phoneT_column = all_tr[i].getElementsByTagName("td")[3];
            if (nameT_column && phoneT_column) {
                var nameT_value = nameT_column.textContent || nameT_column.innerText;
                var phoneT_value = phoneT_column.textContent || phoneT_column.innerText;
                nameT_value = nameT_value.toUpperCase();
                phoneT_value = phoneT_value.toUpperCase();
                if ((nameT_value.indexOf(keyword) > -1) || (phoneT_value.indexOf(keyword) > -1)) {
                    all_tr[i].style.display = ""; // show
                } else {
                    all_tr[i].style.display = "none"; // hide
                }
            }
        }
    })
}

// search Student by Name of Student or class name
var searchStudent = document.getElementById("txtSearch_Student");
if (searchStudent) {
    searchStudent.addEventListener("keyup", function () {
        var keyword = this.value;
        keyword = keyword.toUpperCase();
        var table_Student = document.getElementById("table_Student");
        var all_tr = table_Student.getElementsByTagName("tr");
        for (var i = 0; i < all_tr.length; i++) {
            var nameST_column = all_tr[i].getElementsByTagName("td")[2];
            var className_column = all_tr[i].getElementsByTagName("td")[9];
            if (nameST_column && className_column) {
                var nameST_value = nameST_column.textContent || nameST_column.innerText;
                var className_value = className_column.textContent || className_column.innerText;
                nameST_value = nameST_value.toUpperCase();
                className_value = className_value.toUpperCase();
                if ((nameST_value.indexOf(keyword) > -1) || (className_value.indexOf(keyword) > -1)) {
                    all_tr[i].style.display = ""; // show
                } else {
                    all_tr[i].style.display = "none"; // hide
                }
            }
        }
    })
}

// search Class by Name of Class or Teacher name
var searchClass = document.getElementById("txtSearch_Class");
if (searchClass) {
    searchClass.addEventListener("keyup", function () {
        var keyword = this.value;
        keyword = keyword.toUpperCase();
        var table_Class = document.getElementById("table_Class");
        var all_tr = table_Class.getElementsByTagName("tr");
        for (var i = 0; i < all_tr.length; i++) {
            var nameClass_column = all_tr[i].getElementsByTagName("td")[2];
            var nameTeacher_column = all_tr[i].getElementsByTagName("td")[3];
            if (nameClass_column && nameTeacher_column) {
                var nameClass_value = nameClass_column.textContent || nameClass_column.innerText;
                var nameTeacher_value = nameTeacher_column.textContent || nameTeacher_column.innerText;
                nameClass_value = nameClass_value.toUpperCase();
                nameTeacher_value = nameTeacher_value.toUpperCase();
                if ((nameClass_value.indexOf(keyword) > -1) || (nameTeacher_value.indexOf(keyword) > -1)) {
                    all_tr[i].style.display = ""; // show
                } else {
                    all_tr[i].style.display = "none"; // hide
                }
            }
        }
    })
}

// search Term by Name of Term
var searchTerm = document.getElementById("txtSearch_Term");
if (searchTerm) {
    searchTerm.addEventListener("keyup", function () {
        var keyword = this.value;
        keyword = keyword.toUpperCase();
        var table_Term = document.getElementById("table_Term");
        var all_tr = table_Term.getElementsByTagName("tr");
        for (var i = 0; i < all_tr.length; i++) {
            var nameTerm_column = all_tr[i].getElementsByTagName("td")[1];
            if (nameTerm_column) {
                var nameTerm_value = nameTerm_column.textContent || nameTerm_column.innerText;
                nameTerm_value = nameTerm_value.toUpperCase();
                if (nameTerm_value.indexOf(keyword) > -1) {
                    all_tr[i].style.display = ""; // show
                } else {
                    all_tr[i].style.display = "none"; // hide
                }
            }
        }
    });
}

// search Account by email or role
var searchAccount = document.getElementById("txtSearch_Account");
if (searchAccount) {
    searchAccount.addEventListener("keyup", function () {
        var keyword = this.value;
        keyword = keyword.toUpperCase();
        var table_Account = document.getElementById("table_Account");
        var all_tr = table_Account.getElementsByTagName("tr");
        for (var i = 0; i < all_tr.length; i++) {
            var email_column = all_tr[i].getElementsByTagName("td")[1];
            var role_column = all_tr[i].getElementsByTagName("td")[3];
            if (email_column && role_column) {
                var email_value = email_column.textContent || email_column.innerText;
                var role_value = role_column.textContent || role_column.innerText;
                email_value = email_value.toUpperCase();
                role_value = role_value.toUpperCase();
                if ((email_value.indexOf(keyword) > -1) || (role_value.indexOf(keyword) > -1)) {
                    all_tr[i].style.display = ""; // show
                } else {
                    all_tr[i].style.display = "none"; // hide
                }
            }
        }
    })
}

// search Feedback Student by name of teacher or name of student or rank of student
var searchfeedbackST = document.getElementById("txtSearch_feedbackST");
if (searchfeedbackST) {
    searchfeedbackST.addEventListener("keyup", function () {
        var keyword = this.value;
        keyword = keyword.toUpperCase();
        var table_feedbackST = document.getElementById("table_feedbackST");
        var all_tr = table_feedbackST.getElementsByTagName("tr");
        for (var i = 0; i < all_tr.length; i++) {
            var nameTeacher_column = all_tr[i].getElementsByTagName("td")[1];
            var nameStudent_column = all_tr[i].getElementsByTagName("td")[2];
            var rank_column = all_tr[i].getElementsByTagName("td")[3];
            if (nameTeacher_column && nameStudent_column && rank_column) {
                var nameTeacher_value = nameTeacher_column.textContent || nameTeacher_column.innerText;
                var nameStudent_value = nameStudent_column.textContent || nameStudent_column.innerText;
                var rank_value = rank_column.textContent || rank_column.innerText;
                nameTeacher_value = nameTeacher_value.toUpperCase();
                nameStudent_value = nameStudent_value.toUpperCase();
                rank_value = rank_value.toUpperCase();
                if ((nameTeacher_value.indexOf(keyword) > -1) || (nameStudent_value.indexOf(keyword) > -1)
                        || (rank_value.indexOf(keyword) > -1)) {
                    all_tr[i].style.display = ""; // show
                } else {
                    all_tr[i].style.display = "none"; // hide
                }
            }
        }
    })
}

// search Feedback Teacher by name of teacher or name of parent or rank of teacher
var searchfeedbackTeacher = document.getElementById("txtSearch_feedbackTeacher");
if (searchfeedbackTeacher) {
    searchfeedbackTeacher.addEventListener("keyup", function () {
        var keyword = this.value;
        keyword = keyword.toUpperCase();
        var table_feedbackTeacher = document.getElementById("table_feedbackTeacher");
        var all_tr = table_feedbackTeacher.getElementsByTagName("tr");
        for (var i = 0; i < all_tr.length; i++) {
            var nameTeacher_column = all_tr[i].getElementsByTagName("td")[1];
            var nameParent_column = all_tr[i].getElementsByTagName("td")[2];
            var rank_column = all_tr[i].getElementsByTagName("td")[3];
            if (nameTeacher_column && nameParent_column && rank_column) {
                var nameTeacher_value = nameTeacher_column.textContent || nameTeacher_column.innerText;
                var nameParent_value = nameParent_column.textContent || nameParent_column.innerText;
                var rank_value = rank_column.textContent || rank_column.innerText;
                nameTeacher_value = nameTeacher_value.toUpperCase();
                nameParent_value = nameParent_value.toUpperCase();
                rank_value = rank_value.toUpperCase();
                if ((nameTeacher_value.indexOf(keyword) > -1) || (nameParent_value.indexOf(keyword) > -1)
                        || (rank_value.indexOf(keyword) > -1)) {
                    all_tr[i].style.display = ""; // show
                } else {
                    all_tr[i].style.display = "none"; // hide
                }
            }
        }
    })
}

// search Attendance by name of class or title
var searchAttendance = document.getElementById("txtSearch_Attendance");
if (searchAttendance) {
    searchAttendance.addEventListener("keyup", function () {
        var keyword = this.value;
        keyword = keyword.toUpperCase();
        var table_Attendance = document.getElementById("table_Attendance");
        var all_tr = table_Attendance.getElementsByTagName("tr");
        for (var i = 0; i < all_tr.length; i++) {
            var title_column = all_tr[i].getElementsByTagName("td")[1];
            var nameClass_column = all_tr[i].getElementsByTagName("td")[3];
            if (title_column && nameClass_column) {
                var title_value = title_column.textContent || title_column.innerText;
                var nameClass_value = nameClass_column.textContent || nameClass_column.innerText;
                title_value = title_value.toUpperCase();
                nameClass_value = nameClass_value.toUpperCase();
                if ((title_value.indexOf(keyword) > -1) || (nameClass_value.indexOf(keyword) > -1)) {
                    all_tr[i].style.display = ""; // show
                } else {
                    all_tr[i].style.display = "none"; // hide
                }
            }
        }
    })
}