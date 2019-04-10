import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
import { User } from '../models/user';
var RegistrationComponent = /** @class */ (function () {
    function RegistrationComponent() {
        this.model = new User();
    }
    RegistrationComponent.prototype.ngOnInit = function () {
    };
    RegistrationComponent.prototype.onSubmit = function () { };
    RegistrationComponent = tslib_1.__decorate([
        Component({
            selector: 'app-registration',
            templateUrl: './registration.component.html',
            styleUrls: ['./registration.component.css']
        }),
        tslib_1.__metadata("design:paramtypes", [])
    ], RegistrationComponent);
    return RegistrationComponent;
}());
export { RegistrationComponent };
//# sourceMappingURL=registration.component.js.map