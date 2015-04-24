function acceptLeave(leaveFirstName, leaveLastName) {
    alert("You accepted " + leaveFirstName + " " + leaveLastName + "'s leave.");
    return true;
}

function rejectLeave(leaveFirstName, leaveLastName) {
    alert("You rejected " + leaveFirstName + " " + leaveLastName + "'s leave.");
    return true;
}

function acceptRevision(firstName, lastName, field) {
    alert("You accepted the revision on " + firstName + " " + lastName + "'s" + field + ".");
    return true;
}

function rejectRevision(firstName, lastName, field) {
    alert("You rejected the revision on " + firstName + " " + lastName + "'s" + field + ".");
    return true;
}