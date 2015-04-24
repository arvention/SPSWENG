function acceptLeave(leaveFirstName, leaveLastName) {
    alert("You accepted " + leaveFirstName + " " + leaveLastName + "'s leave.");
    return true;
}

function rejectLeave(leaveFirstName, leaveLastName) {
    alert("You rejected " + leaveFirstName + " " + leaveLastName + "'s leave.");
    return true;
}

function acceptRevision(firstName, lastName, field) {
    alert("You accepted revision on " + firstName + " " + lastName + "'s " + field);
    return true;
}

function rejecttRevision(firstName, lastName, field) {
    alert("You rejected revision on " + firstName + " " + lastName + "'s " + field);
    return true;
}